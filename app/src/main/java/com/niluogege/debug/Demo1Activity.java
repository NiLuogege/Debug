package com.niluogege.debug;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.fastjson.JSONObject;
import com.niluogege.debug.net.AppService;
import com.niluogege.debug.net.BffHttpApi;
import com.xianghuanji.http.base.BaseHttpApi;
import com.xianghuanji.http.base.BaseObserver;
import com.xianghuanji.http.exception.ResponeThrowable;

import io.reactivex.Observable;

/**
 * Created by niluogege on 2020/4/17.
 */
public class Demo1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo1);


        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable a = BffHttpApi.Companion.getInstance().getApi(AppService.class)
                        .getUpdateVersion()
                        .compose(BaseHttpApi.applySchedulers(new BaseObserver<JSONObject>() {
                            @Override
                            protected void onSuccess(JSONObject jsonObject) {
                                log("aaa= "+jsonObject.toJSONString());
                            }

                            @Override
                            protected void onError(ResponeThrowable responeThrowable) {
                                log("bbb= "+responeThrowable.msg);
                            }
                        }));

            }
        });


    }

    private void log(String str) {
        Log.e("aaaaaa", str);
    }
}
