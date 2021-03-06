package com.niluogege.debug;

import android.app.Application;
import android.util.Log;

import com.niluogege.debug.di.DaggerDemoComponent;
import com.niluogege.debug.di.DemoComponent;
import com.niluogege.debug.net.IHttpRequestInfoImpl;
import com.xianghuanji.http.HttpIniter;
import com.xianghuanji.http.base.BaseHttpApi;


/**
 * Created by niluogege on 2020/4/20.
 */
public class App extends Application {


    public static DemoComponent build;

    @Override
    public void onCreate() {
        super.onCreate();
        build = DaggerDemoComponent.builder().application(this).build();
        Log.e("App", "插件的Application 起来啦");


        HttpIniter.init(this);
        BaseHttpApi.setHttpRequestInfo(new IHttpRequestInfoImpl());
    }

    private static DemoComponent getDemoComponent(){
        return  build;
    }
}
