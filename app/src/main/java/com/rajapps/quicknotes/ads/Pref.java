package com.rajapps.quicknotes.ads;

import android.content.Context;
import android.content.SharedPreferences;

// this class is used to store the ads id's
public class Pref {

    public static void setPref(String data, String key, Context context){
        SharedPreferences.Editor editor = context.getSharedPreferences(key,Context.MODE_PRIVATE).edit();
        editor.putString(key,data);
        editor.apply();
    }

    public static String getPref(String key,Context context){
        SharedPreferences preferences = context.getSharedPreferences(key,Context.MODE_PRIVATE);
        return  preferences.getString(key,"");
    }


}
