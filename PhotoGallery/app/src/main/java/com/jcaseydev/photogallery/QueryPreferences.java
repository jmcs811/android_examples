package com.jcaseydev.photogallery;

import android.content.Context;
import android.preference.PreferenceManager;

public class QueryPreferences {
    private static final String PREF_SEARCH_QUERY = "searchQuery";

    public static String getStoredQuery(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(PREF_SEARCH_QUERY, null);
    }

    public static void setStoredQuery(Context conext, String query) {
        PreferenceManager.getDefaultSharedPreferences(conext)
                .edit()
                .putString(PREF_SEARCH_QUERY, query)
                .apply();
    }
}
