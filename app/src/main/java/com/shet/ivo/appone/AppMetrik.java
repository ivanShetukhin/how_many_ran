package com.shet.ivo.appone;

import android.app.Application;
import android.content.Context;

import com.yandex.metrica.YandexMetrica;

/**
 * Created by ivo on 02.08.17.
 */

public class AppMetrik extends Application {

    private static AppMetrik instance;
    private static Context mContext;

    public static AppMetrik getInstance() {
        if(null == instance){
            instance = new AppMetrik();
        }
        return instance;
    }

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mContext = getApplicationContext();
    }




}
