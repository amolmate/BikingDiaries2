package rider.bikingdiaries.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.util.TypedValue;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.toolbox.JsonObjectRequest;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;

import rider.bikingdiaries.R;
import rider.bikingdiaries.activity.BaseActivity;
import rider.bikingdiaries.activity.BikingDiaries;
import rider.bikingdiaries.constants.AppConstants;
import rider.bikingdiaries.customview.MyTextView;


@SuppressLint("ResourceAsColor")
public class AppUtility {

	public static boolean showlog = true;
	public static String TAB_POSITION = "tab_pos";

	public static int POST = 1;
	public static int GET = 0;
	public static String SHARED_PREFERENCES = "shared_preferences";
	public static String APP_REG = "app_reg";
	public static String USER_DETAILS = "User";
	public static String WIFI_PACKAGE = "wifipackage";
	public static String MOBILE_NUMBER = "MobileNumber";
	public static String TRANSACTION_ID = "trans_id";
	public static String WIFI_PROFILE_USER_DETAILS = "wifi_profile";

	
	public static boolean isOnline(Context context) {

		boolean haveConnectedWifi = false;
		boolean haveConnectedMobile = false;

		Class[] items = { String.class, Integer.class };

		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(context.CONNECTIVITY_SERVICE);

		NetworkInfo[] netInfo = cm.getAllNetworkInfo();
		for (NetworkInfo ni : netInfo) {
			if (ni.getTypeName().equalsIgnoreCase("WIFI")) {
				if (ni.isConnected()) {
					haveConnectedWifi = true;
					System.out.println("WIFI CONNECTION AVAILABLE");
				} else {
					System.out.println("WIFI CONNECTION NOT AVAILABLE");
				}
			}
			if (ni.getTypeName().equalsIgnoreCase("MOBILE")) {
				if (ni.isConnected()) {
					haveConnectedMobile = true;
					System.out.println("MOBILE INTERNET CONNECTION AVAILABLE");
				} else {
					System.out
							.println("MOBILE INTERNET CONNECTION NOT AVAILABLE");
				}
			}

		}
		return haveConnectedWifi || haveConnectedMobile;

	}

	public static void l(String name, String value) {
		if (showlog) {
			// Log.d(name,value);

			if (value.length() > 4000) {
				Log.e(name, value.substring(0, 4000));
				// log(name,value.substring(4000));
			} else
				Log.e(name, value);
		}
	}
	
	public static void show_dialog(final Context ctx, String title,
			String message, final boolean finish) {
		Effectstype effect = Effectstype.Slidetop;
		BaseActivity.dialog_box = NiftyDialogBuilder.getInstance(ctx);
		BaseActivity.dialog_box
				/*
				 * .withTitle("Confirmation") .withTitle(null) no title
				 * .withTitleColor(ctx.getString(R.color.theme_color))
				 */
				// def
				.withTitle(null)
				.withDividerColor("#eeeeee")
				// def
				// .withMessage(Message) //.withMessage(null) no Msg
				.withMessage(null)
				.withMessageColor("#eeeeee")
				// def | withMessageColor(int resid)
				.withDialogColor("#eeeeee")
				// def | withDialogColor(int resid) //def
				.withIcon(
						ctx.getResources().getDrawable(R.mipmap.ic_launcher))
				.isCancelableOnTouchOutside(finish?false:true) // def | isCancelable(true)
				.withDuration(700)
				.isCancelable(finish?false:true)
				// def
				.withEffect(effect).setCustomView(R.layout.simple_dialog, ctx)// def
																			// Effectstype.Slidetop
				.show();
		
		MyTextView tv_meesage = (MyTextView) BaseActivity.dialog_box
				.findViewById(R.id.tv_message);
		Button btn_ok = (Button) BaseActivity.dialog_box
				.findViewById(R.id.btn_next);
		btn_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (BaseActivity.dialog_box != null) {
					BaseActivity.dialog_box.dismiss();
				}
				if (finish) {
					((Activity) ctx).finish();
				}
			}
		});
		
		tv_meesage.setText(message);
	}

	public static final String getAndroidId() {
		return android.provider.Settings.Secure.getString(BikingDiaries.getInstance().getAppContext()
						.getContentResolver(),
				android.provider.Settings.Secure.ANDROID_ID);
	}

	private static final String TAG = AppUtility.class.getSimpleName();

	public static boolean checkInternetConnection() {
		final Context context = BikingDiaries.getInstance().getAppContext();
		if (!connectivity(context)) {
			BikingDiaries.getInstance().getMainThreadHandler().post(new Runnable() {
				@Override
				public void run() {
					Toast toast = null;
					if (toast == null) {
						toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
					}
					toast.setText(AppConstants.TXT_NO_CONNECTION);
					toast.show();

				}
			});
			return false;
		}
		return true;
	}

	public static boolean isDataPacketConnected() {

		ConnectivityManager connManager = (ConnectivityManager) BikingDiaries.getInstance().getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

		if (networkInfo != null) {
			if (networkInfo.isConnected()) {
				return true;
			}
		}
		return false;
	}

	public static boolean isWiFiConnected() {

		ConnectivityManager connManager = (ConnectivityManager) BikingDiaries.getInstance().getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

		if (networkInfo.isConnected()) {
			return true;
		}
		return false;
	}
	
	
	public static boolean connectivity(Context context) {
		ConnectivityManager connec = (ConnectivityManager) (context
				.getSystemService(Context.CONNECTIVITY_SERVICE));
		NetworkInfo info = connec.getActiveNetworkInfo();
		boolean connected = false;
		if (info != null && info.isAvailable()) {
			connected = info.isConnected();
		}
		return connected;
	}

	public static void showToast(final String text) {
		BikingDiaries.getInstance().getMainThreadHandler().post(new Runnable() {
			@Override
			public void run() {
				Toast toast = null;
				if (toast == null) {
					toast = Toast.makeText(BikingDiaries.getInstance().getAppContext(), text, Toast.LENGTH_LONG);
				}
				toast.show();
			}
		});
	}

	public static int actionBarHeight() {
		int actionBarHeight = 0;
		TypedValue tv = new TypedValue();
		if (BikingDiaries.getInstance().getApplicationContext()
				.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
			actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,
					BikingDiaries.getInstance().getApplicationContext().getResources().getDisplayMetrics());

		}
		return actionBarHeight;
	}

	public static void addShortcut() {
		Context context = BikingDiaries.getInstance().getApplicationContext();
		Intent shortcutIntent = new Intent(Intent.ACTION_MAIN);
		String rootPkgName = context.getPackageName();
		String launcherClsName = BikingDiaries.class.getName();
		shortcutIntent.setClassName(rootPkgName, launcherClsName);

		Intent addIntent = new Intent();
		addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
		addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME,
				BikingDiaries.getInstance().getApplicationContext().getResources().getString(R.string.app_name)
		);
		addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
				Intent.ShortcutIconResource.fromContext(context,
						R.mipmap.ic_launcher));
		addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
		addIntent.putExtra("duplicate", false);
		context.sendBroadcast(addIntent);
	}

	public static void deleteShortcut(String classNameSpace) {
		Context context = BikingDiaries.getInstance().getApplicationContext();
		Intent shortcutIntent = new Intent(Intent.ACTION_MAIN);
		shortcutIntent.setClassName("com.mauj.BikingDiaries", classNameSpace);
		Intent addIntent = new Intent();
		addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
		addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, R.string.app_name);
		addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
				Intent.ShortcutIconResource.fromContext(context,
						R.mipmap.ic_launcher));
		addIntent.putExtra("duplicate", false);
		addIntent.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
		context.sendBroadcast(addIntent);
	}

	public static void increaseToucharea(final View btnBg, final int left,
										 final int top, final int right, final int bottom) {
		final View btnParent = (View) btnBg.getParent();
		btnParent.post(new Runnable() {
			public void run() {
				final Rect r = new Rect();
				btnBg.getHitRect(r);
				r.top -= top;
				r.bottom += bottom;
				r.left -= left;
				r.right += right;
				btnParent.setTouchDelegate(new TouchDelegate(r, btnBg));
			}
		});
	}

	public static boolean checkPermission(String permission) {
		if (FWCompat.isMarshmallow_23__OrNewer()) {
			int hasPermission = BikingDiaries.getInstance().getApplicationContext().checkSelfPermission(permission);
			if (hasPermission == PackageManager.PERMISSION_GRANTED) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	public static AppConstants.NETWORK_TYPE getDownloadNetworkType() {
		if (isWiFiConnected()) {
			return AppConstants.NETWORK_TYPE.WIFI;
		}
		return AppConstants.NETWORK_TYPE.DATA_PACKET;
	}

}
