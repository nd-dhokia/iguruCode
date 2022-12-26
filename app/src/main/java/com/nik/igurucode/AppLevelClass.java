package com.nik.igurucode;

import android.app.Application;

import com.squareup.otto.Bus;

public class AppLevelClass extends Application {

    private static AppLevelClass application;

    private Bus bus;

    public static AppLevelClass getInstance() {
        return application;
    }



    public Bus getBus() {
        return bus;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        bus = new Bus();
    }

}
