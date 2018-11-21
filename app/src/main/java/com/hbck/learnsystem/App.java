package com.hbck.learnsystem;

import android.app.Application;

import com.hbck.learnsystem.util.SpUtil;

/**
 * @Date 2018-11-19.
 */
public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        SpUtil.init(this);
    }
}
