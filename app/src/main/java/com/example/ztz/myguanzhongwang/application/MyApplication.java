package com.example.ztz.myguanzhongwang.application;

import android.app.Application;

import com.example.ztz.myguanzhongwang.api.API;
import com.facebook.drawee.backends.pipeline.Fresco;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ztz on 2017/12/15.
 */

public class MyApplication extends Application{

    public static API api;
    public static API api1;

    @Override
    public void onCreate() {
        super.onCreate();
        Retrofit builder = new Retrofit.Builder()

                .baseUrl("http://api.kkmh.com/")

                .addConverterFactory(GsonConverterFactory.create())

                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        api = builder.create(API.class);

        Fresco.initialize(this);

        Retrofit builder1 = new Retrofit.Builder()

                .baseUrl("https://www.zhaoapi.cn/")

                .addConverterFactory(GsonConverterFactory.create())

                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        api1 = builder1.create(API.class);
    }
}
