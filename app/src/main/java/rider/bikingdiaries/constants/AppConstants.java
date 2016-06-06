package rider.bikingdiaries.constants;

import android.util.Log;


import org.json.JSONObject;

import rider.bikingdiaries.activity.BikingDiaries;

/**
 * Created by akashb on 24/6/15.
 */
public class AppConstants {

    public static boolean isVideoComponentEnabled = Boolean.FALSE;
    public static final String DATABASE_NAME = "GamesBDb";
    public static boolean isTestBuild = false;// false

    public static boolean showOpenSearch = true;// false
    public static boolean isDrawerOpen = false;

    public final static String APP_LANG = "en";
    public final static String TXT_GCM_PROJECT_ID = "347614459502";

    public static int DEVICE_HEIGHT;
    public static int DEVICE_WIDTH;
    public final static String CATEGORY_NAME = "CATEGORY_NAME";
    public final static String CATEGORY_ID = "CATEGORY_ID";
    public final static String GROUP_ID = "GROUP_ID";
    public final static String CONTENT_ID = "CONTENT_ID";
    public final static String CONTENT_TYPE_ID = "CONTENT_TYPE_ID";
    public final static String VIDEO_AUTO_PLAY = "VIDEO_AUTO_PLAY";

    public static String GROUP_TITLE = "GROUP_TITLE";
    public final static String SEARCH_KEYWORD = "SEARCH_KEYWORD";
    public final static String SEARCH_BY_TAG = "SEARCH_BY_TAG";
    public final static String MY_ACCOUNT_LIST_TYPE = "MY_ACCOUNT_LIST_TYPE";
    public final static String MY_ACCOUNT_LIST_TITLE = "MY_ACCOUNT_LIST_TITLE";

    public final static String ACTIONBAR_TITLE = "ACTIONBAR_TITLE";


    public final static String PAID = "paid";
    public final static String FREE = "free";
    public final static String SUBSCRIBE = "Subscribe";
    public final static String DOWNLOAD = "Download";

    public final static String DEFAULT_STRING = "";
    public final static int DEFAULT_INT = -1;
    public final static String DEFAULT_GROUP_ID = "123,124";
    public final static String DEFAULT_PRODUCT_ID = "gm-p";


    public final static String DISPLAY_TYPE_SPECIAL = "special_close";

    public final static String GRID_3 = "GRID_3";
    public final static String GRID = "GRID_2";
    public final static String LIST = "LIST";
    public final static String LIST_OPEN = "LIST_OPEN";
    public final static String LIST_CLOSE = "LIST_CLOSE";
    public final static String LIST_MY_ACCOUNT = "LIST_MY_ACCOUNT";
    public final static String CROUSEL = "CROUSEL";
    public final static String CATEGORY = "CATEGORY";
    public final static String BANNER = "banner";
    public final static String VIDEO_LIST_OPEN = "VIDEO_LIST_OPEN";
    public final static String VIDEO_LIST_CLOSE = "VIDEO_LIST_CLOSE";
    public final static String SPECIAL_CLOSE = "special_close";
    public final static String TOP_CATEGORIES = "top_categories";




    public final static String TXT_UNSUBSCRIBE = "Unsubscribe";
    public final static String TXT_LOGIN = "Login";
    public final static String TXT_UPDATE_APP = "Update App";
    public final static String TXT_INSTALL_APP = "Install App";
    public final static String TXT_HOME = "Home";
    public final static String TXT_CATEGORY = "Browse Categories";
    public final static String TXT_BROWSE_CHANNELS = "Game Collections";
    public final static String TXT_RECOMMENDED_GAMES = "Recommended Games";
    public final static String TXT_MY_ACTIVITIES = "My Activities";
    public final static String TXT_NO_CONNECTION_DOWNLOAD = "No network. Download will resume when network is available.";
    public final static String TXT_NO_CONNECTION = "No Network.";


    public final static String TXT_SCREENSHOT_VERTICAL = "vertical";
    public final static String TXT_SCREENSHOT_HORIZONTAL = "horizontal";

    public final static String INT_RECOMMENDED_FOR_YOU = "125";


    public final static String TXT_IDEA_COMPANY_ID = "11";
    public final static String TXT_URL = "URL";
    public final static String TXT_HTML5 = "html5";
    public final static String TXT_GAME = "apk";
    public final static String TXT_LISTING_MODEL = "TXT_LISTING_MODEL";
    public final static String TXT_CONTENT_ID = "CONTENT_ID";


    public final static String TXT_VIDEO_ASSOC_CONTENT_TYPE_ID = "VIDEO_ASSOC_GAME_CONTENT_TYPE_ID";

    public final static String TXT_CONTENT_NAME = "CONTENT_NAME";
    public final static String TXT_SPECIAL_CLOSE = "special_close";
    public final static String TXT_Recently_Downloaded = "Recently Downloaded";
    public final static String TXT_Recently_Visited = "Recently Visited";
    public final static String TXT_RECOMMENDED_FOR_YOU = "Recommended Games";
    public static String TXT_CURRENT_PAGE = "";
    public static String TXT_PREVIOUS_PAGE = "";
    public static String USER_LANDING_PAGE = "";
    public static String POPULAR_SEARCH_PREVIOUS_PAGE = "";

    public final static String TXT_POPULAR_SEARCHES = "Popular Searches";
    public final static String TXT_RECOMMENDED_TAGS = "Recommended Tags";

    public final static String TXT_FRAGMENT_POSITION = "FRAGMENT_POSITION";

    public static final String WHATS_APP_PKG_NAME = "com.whatsapp";

    public static final String constantPrefName = "Constants";
    public static final String X_WINIT_IMEI = "strIMEI";

    public final static int INT_720_WIDTH = 720;
    public final static int INT_320_WIDTH = 320;

    public final static String ERROR_PARSING = "Communication error.";
    public final static String ERROR_CONNECTION = "Connection error";
    public static String campaignIdThroughGcm;

    public static final int INT_CONTENT_TYPE_GAME = 10;
    public static final int INT_CONTENT_TYPE_VIDEO = 9;

    public final static String TXT_CONTENT_TYPE_ID = "CONTENT_TYPE_ID";
    public final static String TXT_CONTENT_VIDEO_ID = "VIDEO_ID";


    public final static String TXT_VIDEO_ASSOC_GAMES_CONTENT_TYPE_ID = "VIDEO_ASSOC_GAME_CONTENT_TYPE_ID";
    public final static String TXT_VIDEO_ASSOC_GAME_ID = "VIDEO_ASSOC_GAME_ID";

    public final static String TXT_CONTENT_VIDEO_TYPE = "VIDEO_TYPE";

    public static final String VIDEO_GAME_PLAY = "gameplay";
    public static final String VIDEO_ENTERTAINMENT = "entertainment";


    public enum NETWORK_TYPE {
        WIFI, DATA_PACKET
    }

//    public enum DOWNLOAD_STATUS {
//        DEFAULT, DOWNLOADING, A_PAUSE, M_PAUSE, DOWNLOADED, INSTALLED, CANCELED, UPDATE
//    }

    public enum CONTENT_VISIBLE_STATUS {
        VISIBLE, INVISIBLE
    }

    public enum USER_STATE {
        ACTIVE, NOT_ACTIVE, SUSPEND, GRACE, PARKING
    }

    public enum GRID_TYPE {
        GRID_2, GRID_3, SPECIAL_CLOSE
    }

    public enum CARD_TYPE {
        LIST_OPEN, LIST_CLOSE, LIST_MY_ACCOUNT, GRID_2, GRID_3, SPECIAL_CLOSE, CAROUSEL, CAROUSEL_BANNER, CATEGORY, VIDEO_LIST_OPEN, VIDEO_LIST_CLOSE
    }


//    public enum VIEW_TYPE {
//        LIST_OPEN, LIST_CLOSE, GRID_2, GRID_3, SPECIAL_CLOSE, CAROUSEL, CAROUSEL_BANNER, CATEGORY, MY_ACCOUNT_LIST, VIDEO_LIST_OPEN, VIDEO_LIST_CLOSE
//    }

    public enum GROUP_TYPE {
        GROUP_GAME, GROUP_VIDEO, GROUP_CATEGORY, GROUP_CHANNEL, GROUP_BANNER
    }

    public final static String TXT_CONTENT_VISIBLE = "CONTENT_VISIBLE";
    public final static String TXT_CONTENT_INVISIBLE = "CONTENT_INVISIBLE";

    public final static String TXT_WIFI = "WIFI";
    public final static String TXT_DATA_PACKET = "DATA_PACKET";
    public final static String UNKNOWN_NETWORK = "UNKNOWN_NETWORK";


    public final static String TXT_INSTALL = "Install";
    public final static String TXT_OPEN = "Open";
    public final static String TXT_DOWNLOADING = "Downloading";
    public final static String TXT_RESUME = "Resume";
    public final static String TXT_PAUSE = "Pause";
    public final static String TXT_UPDATE = "Update";
    public final static String TXT_RETRY = "Retry";

//    public final static int INT_DEFAULT = 0;
//    public final static int INT_DOWNLOADING = 1;
//    public final static int INT_A_PAUSE = 2;
//    public final static int INT_M_PAUSE = 3;    //Auto Pause
//    public final static int INT_DOWNLOADED = 4; //Manual Pause
//    public final static int INT_INSTALLED = 5;
//    public final static int INT_CANCELED = 6;
//    public final static int INT_UPDATE = 7;

    public static String GB_USER_ID = "GB_USER_ID";
    public static String GB_COMPANY_ID = "GB_COMPANY_ID";
    public static String GB_PRODUCT_ID = "GB_PRODUCT_ID";
    public static String GB_CAMPAIGN_ID = "GB_CAMPAIGN_ID";
    public static String GB_APP_VERSION_CODE = "GB_APP_VERSION_CODE";
    //for pageflow
    public static String GB_CIRCLE_NAME = "GB_CIRCLE_NAME";
    public static String GB_CONTEXT_NAME = "GB_CONTEXT_NAME";
    public static String GB_ACTION_NAME = "GB_ACTION_NAME";
    public static String GB_IS_SUBSCRIBE = "GB_IS_SUBSCRIBE";
    public static String GB_SUB_ID = "GB_SUB_ID";
    public static String GB_CIRCLE_ID = "GB_CIRCLE_ID";
    public static String GB_OPERATOR_ID = "GB_OPERATOR_ID";
    public static String GB_DEVICE_MODEL = "GB_DEVICE_MODEL";

    public static String GB_POINTING_METHOD = "GB_POINTING_METHOD";
    public static String GB_OS_VERSION = "GB_OS_VERSION";
    public static String GB_SCREEN_HEIGHT = "GB_SCREEN_HEIGHT";

    public static String GB_DEVICE_ID = "GB_DEVICE_ID";
    public static String GB_BRAND_NAME = "GB_BRAND_NAME";
    public static String GB_PLATFORM = "GB_PLATFORM";
    public static String GB_SCREEN_WIDTH = "GB_SCREEN_WIDTH";
    public static String GB_LANDING_PAGE = "GB_LANDING_PAGE";


    public static String GB_CONTEXT_ID = "GB_CONTEXT_ID";
    public static String GB_COUNTRY = "GB_COUNTRY";
    public static String GB_IS_NEW_VISITOR = "GB_IS_NEW_VISITOR";
    public static String GB_IS_WIFI_USER = "GB_IS_WIFI_USER";
    public static String GB_LAST_PAGE_NAME = "GB_LAST_PAGE_NAME";
    public static String GB_NETWORK_TYPE = "GB_NETWORK_TYPE";
    public static String GB_OPERATOR = "GB_OPERATOR";
    public static String GB_PAGE_NAME = "GB_PAGE_NAME";
    public static String GB_SESSION_ID = "GB_SESSION_ID";
    public static String GB_SUB_STAGE = "GB_SUB_STAGE";
    public static String GB_WURFL_ID = "GB_WURFL_ID";
    public static String GB_KEYWORD = "GB_KEYWORD";

    /* Constants for Actions**/
    public static String btnViewAll = "View All";
    public static String btnLoadmore = "Load More";
    public static String btnSearch = "Search";
    public static String btnSearchOpenBar = "Search Open Bar";
    public static String btnMyActivities = "MyActivities";
    public static String PAGE_RECOMMENDED_FOR_YOU = "PAGE_RECOMMENDED_FOR_YOU";


    public final static String VIEWTYPE_CREDIT_COUNT = "VIEWTYPE_CREDIT_COUNT";
    public final static String VIEWTYPE_UNSUBSCRIBE = "VIEWTYPE_UNSUBSCRIBE";
    public final static String VIEWTYPE_HEADER = "VIEWTYPE_HEADER";


    public final static String TXT_ACTION = "TXT_ACTION";

    public final static String ACTION_RESUME = "ACTION_RESUME";

    public final static String ACTION_SWIPE_OUT = "ACTION_SWIPE_OUT";

    public static final String STORE_NAME = "GamesBond";

    public static int PADDING_8_H;
    public static int PADDING_8_V;
    public static int PADDING_8;
    public static int PADDING_16;
    public static int PADDING_24;
    public static int TOP_PADDING_IN_CARD;


//    public static int GAMESBOND_APP_ID = 20038008;

    public static final long MILLIS = 1L;
    public static final long SECOND_IN_MILLIS = 1000 * MILLIS;
    public static final long MINUTES_IN_MILLIS = 60 * SECOND_IN_MILLIS;
    public static final long HOUR_IN_MILLIS = 60 * MINUTES_IN_MILLIS;
    public static final long DAY_IN_MILLIS = 24 * HOUR_IN_MILLIS;
    public static final long MONTH_IN_MILLIS = 30 * DAY_IN_MILLIS;
    public static final long YEAR_IN_MILLIS = 12 * MONTH_IN_MILLIS;


    public static String KEY_SUBSCRIBE_STATUS_CHK_COUNTER = "KEY_SUBSCRIBE_STATUS_CHK_COUNTER";

    public static void log(String TAG, String logString) {
        if (isTestBuild)
            Log.e(TAG, logString);
    }

    public static boolean isLiveUrl = true;

    //Test developer Key
    //public static String youTubeDeveloperKey = "AIzaSyAYoKbMwkLn7shiUnoslTOPEL5sh9pLpQM";

    /* Live developer Key**/
    public static String youTubeDeveloperKey = "AIzaSyAiVxkcqV4IailxqcGiCaZ3Ium8FN60y5o";


    //Beta
    public static String betaLoginURL = "http://wap.mauj.com/BETAAPI/GAMESBOND_V2/?method=login&params=";
//    public static String betaLoginURL = "http://wap.mauj.com/BETAAPI/GAMESBOND_V1/?method=login&params=";
    public static String liveLoginURL = "http://wap.mauj.com/API/GAMESBOND_V2/?method=login&params=";
//    public static String tracePageURL = "http://wap.mauj.com/BETAAPI/GAMESBOND_V1/?";
//    public static String postUserAppsURL = "http://wap.mauj.com/BETAAPI/GAMESBOND_V1/?method=traceapp";

    public static String appUrl = "";

    public static String jsonToString(JSONObject jsonObject) {
        return jsonObject.toString();
    }

    public static void setUrl() {
        if (isLiveUrl) {
            appUrl = AppConstants.liveLoginURL;
        } else {
            appUrl = AppConstants.betaLoginURL;
        }
    }
}
