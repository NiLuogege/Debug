package com.niluogege.debug.net;

import com.alibaba.fastjson.JSONObject;
import com.xianghuanji.http.bean.BaseRespose;

import io.reactivex.Observable;
import retrofit2.http.POST;

public interface AppService {

    @POST("/app/version")
    Observable<BaseRespose<JSONObject>> getUpdateVersion();


}
