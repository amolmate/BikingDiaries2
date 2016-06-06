

package rider.bikingdiaries.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import rider.bikingdiaries.activity.BikingDiaries;
import rider.bikingdiaries.impl.IList;

/**
 * Used to store application related data in shared preference
 *
 * @author akash.bane
 */
public class AndroidSharedPreference {

    public static void saveIntToPref(String key, int intValue) {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(BikingDiaries.getInstance().getApplicationContext());
        SharedPreferences.Editor prefsEditor = preferences.edit();
        prefsEditor.putInt(key, intValue);
        prefsEditor.commit();
    }

    public static int getIntFromPref(String key) {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(BikingDiaries.getInstance().getApplicationContext());
        return preferences.getInt(key, 0);
    }

    public static void saveStringToPref(String key,
                                        String stringValue) {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(BikingDiaries.getInstance().getApplicationContext());
        SharedPreferences.Editor prefsEditor = preferences.edit();
        prefsEditor.putString(key, stringValue);
        prefsEditor.commit();
    }


    public static String getStringFromPref(String key) {
        Context appContext = BikingDiaries.getInstance().getApplicationContext();
        String stringPref = "";
        if(appContext != null) {
            SharedPreferences preferences = PreferenceManager
                    .getDefaultSharedPreferences(appContext);
            stringPref = preferences.getString(key, "");
        }
        return stringPref;
    }

    public static void saveBooleanToPref(String key,
                                         boolean booleanValue) {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(BikingDiaries.getInstance().getApplicationContext());
        SharedPreferences.Editor prefsEditor = preferences.edit();
        prefsEditor.putBoolean(key, booleanValue);
        prefsEditor.commit();
    }

    public static boolean getBooleanFromPref(String key) {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(BikingDiaries.getInstance().getApplicationContext());
        return preferences.getBoolean(key, false);
    }

    public static void saveLongToPref( String key, long longValue) {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(BikingDiaries.getInstance().getApplicationContext());
        SharedPreferences.Editor prefsEditor = preferences.edit();
        prefsEditor.putLong(key, longValue);
        prefsEditor.commit();
    }

    public static Long getLongFromPref( String key) {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(BikingDiaries.getInstance().getApplicationContext());
        return preferences.getLong(key, 0L);
    }

    public static void saveObjectInPreference(String strKey, Object obj) {
        Gson gson = new GsonBuilder().registerTypeAdapter(IList.class,
                new InterfaceAdapter<IList>()).create();// ashishv added
        String json = gson.toJson(obj);
        saveStringToPref( strKey, json);
    }

}
