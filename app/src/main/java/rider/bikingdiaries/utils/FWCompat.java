package rider.bikingdiaries.utils;

import android.os.Build;

public class FWCompat {
    public static boolean isFroyo_8_OrNewer() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO;
    }
    public static boolean isGingerbread_9_OrNewer() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;
    }
    public static boolean isUpdatedGingerBread_10_OrNewer() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD_MR1;
    }
    public static boolean isHoneycomb_11_OrNewer() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }
    public static boolean isHoneycomb_13_OrNewer() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2;
    }
    public static boolean isIceCreamSandwich_14_OrNewer() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
    }
    public static boolean isJellyBean_16_OrNewer() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }   
    public static boolean isJellyBean_MR2_18_OrNewer() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2;
    }
    public static boolean isKitKat_19_OrNewer() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }
    public static boolean isLolipop_21__OrNewer(){
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }
    public static boolean isMarshmallow_23__OrNewer(){
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }
}

