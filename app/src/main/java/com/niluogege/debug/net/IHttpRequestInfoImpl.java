package com.niluogege.debug.net;

import com.xianghuanji.http.base.IHttpRequestInfo;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Interceptor;

public class IHttpRequestInfoImpl implements IHttpRequestInfo {
    @Override
    public boolean isTest() {
        return true;
    }

    @Override
    public boolean isAddParamsFilterInterceptor() {
        return false;
    }

    @Override
    public int getParamsFilterUselessNumber() {
        return 0;
    }

    @Override
    public HashMap<String, String> getRequestHeaderMap() {
        return null;
    }

    @Override
    public ArrayList<Interceptor> getInterceptors() {
        return null;
    }
}
