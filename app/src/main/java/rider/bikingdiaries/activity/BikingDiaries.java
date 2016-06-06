package rider.bikingdiaries.activity;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import java.io.File;
import rider.bikingdiaries.constants.AppConstants;
import rider.bikingdiaries.utils.LruBitmapCache;


public class BikingDiaries extends Application {

	public static Bus mEventBus;

	/**
	 * Singleton reference for app.
	 */
	private static BikingDiaries bikingDiaries;

	/**
	 * Hold currennt app context.
	 */
	private Context appContext;

	private RequestQueue requestQueue;
	private ImageLoader imageLoader;

	private static Handler mainthreadhandler;


	/**
	 * Get the current context.
	 *
	 * @return Context.
	 */
	public Context getAppContext() {
		return appContext;
	}

	/**
	 * Get the reference of AndroidApp.
	 *
	 * @return AndroidApp
	 */
	public static BikingDiaries getInstance() {
		return bikingDiaries;
	}

	public RequestQueue getRequestQueue() {
		return requestQueue;
	}

	public ImageLoader getImageLoader() {
		return imageLoader;
	}
	/**
	 * @return a {@link Handler} tied to the main thread.
	 */
	public static Handler getMainThreadHandler() {
		if (mainthreadhandler == null) {
			// No need to synchronize -- it's okay to create an extra Handler,
			// which will be used only once and then thrown away.
			mainthreadhandler = new Handler(Looper.getMainLooper());
		}
		return mainthreadhandler;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		appContext = getApplicationContext();
//        requestQueue = Volley.newRequestQueue(this);
		requestQueue = newRequestQueue(this);
		imageLoader = new ImageLoader(this.requestQueue,
				new LruBitmapCache());
		bikingDiaries = this;
		AppConstants.setUrl();
		mEventBus = new Bus(ThreadEnforcer.ANY);
	}

	private RequestQueue newRequestQueue(Context context) {
		// define cache folder
		// Default maximum disk usage in bytes
		int DEFAULT_DISK_USAGE_BYTES = 25 * 1024 * 1024;

// Default cache folder name
		String DEFAULT_CACHE_DIR = "photos";

		File rootCache = context.getExternalCacheDir();
		if (rootCache == null) {
//            L.w("Can't find External Cache Dir, "
//                    + "switching to application specific cache directory");
			rootCache = context.getCacheDir();
		}

		File cacheDir = new File(rootCache, DEFAULT_CACHE_DIR);
		cacheDir.mkdirs();

		HttpStack stack = new HurlStack();
		Network network = new BasicNetwork(stack);
		DiskBasedCache diskBasedCache = new DiskBasedCache(cacheDir, DEFAULT_DISK_USAGE_BYTES);
		RequestQueue queue = new RequestQueue(diskBasedCache, network);
		queue.start();

		return queue;
	}

	public static Bus getEventBus() {
		return mEventBus;
	}

}