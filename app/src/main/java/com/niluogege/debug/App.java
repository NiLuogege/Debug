package com.niluogege.debug;

import android.app.Application;
import android.util.Log;

import com.niluogege.debug.di.DaggerDemoComponent;
import com.niluogege.debug.di.DemoModule;


/**
 * Created by niluogege on 2020/4/20.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerDemoComponent.builder().demoModule(new DemoModule(this)).build();

        Log.e("App", "插件的Application 起来啦");
    }
}
