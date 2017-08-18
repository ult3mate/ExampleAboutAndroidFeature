package com.pattadon.sampleapplicationproject.manager;

import android.content.Context;

/**
 * Created by Beer on 3/30/16.
 * 23Perspective Android Team
 */
public class ContexterManager {
    private Context context;
    private static ContexterManager contexterInstance = null;

    public static ContexterManager getInstance() {
        if (contexterInstance == null) {
            contexterInstance = new ContexterManager();
        }
        return contexterInstance;
    }

    private ContexterManager(){
    }

    public void setApplicationContext(Context context){
        this.context = context;
    }

    public Context getApplicationContext(){
        return context;
    }

}
