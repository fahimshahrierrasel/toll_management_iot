package com.fahimshahrierrasel.mycartoll;

import android.app.Application;
import android.content.res.Resources;

public class MyCarTollApp extends Application {
    private static MyCarTollApp mInstance;
    private static Resources res;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        res = getResources();
    }

    public static MyCarTollApp getInstance() {
        return mInstance;
    }

    public static Resources getRes() {
        return res;
    }
}
