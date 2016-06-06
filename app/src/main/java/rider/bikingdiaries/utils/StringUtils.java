package rider.bikingdiaries.utils;

import android.text.TextUtils;


public class StringUtils {


    public static int str2Int(String sb) {
        if (TextUtils.isEmpty(sb))
            return 0;
        try {
            return Integer.valueOf(sb);
        } catch (Exception e) {
        }
        return 0;
    }


}
