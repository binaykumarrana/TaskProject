package com.binay.taskproject.services;

import android.util.Log;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by Binay on 12/03/17.
 */

public class ServiceGenerator {
    public static String BASE_URL = "https://ec2-52-220-95-9.ap-southeast-1.compute.amazonaws.com/api/goal-plan";

    private ServiceGenerator() {
    }

    public static <S> S createService(Class<S> serviceClass) {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(60, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(60, TimeUnit.SECONDS);
        okHttpClient.setWriteTimeout(240, TimeUnit.SECONDS);
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new RestAdapter.Log() {
                    @Override
                    public void log(String msg) {
                        Log.d("RetroO", "msg = " + msg);
                        Log.d("Retro", msg);
                    }
                })
                .setClient(new OkClient(new OkHttpClient()));

        RestAdapter adapter = builder.build();

        return adapter.create(serviceClass);
    }

}
