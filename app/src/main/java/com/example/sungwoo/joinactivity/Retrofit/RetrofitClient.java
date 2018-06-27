package com.example.sungwoo.joinactivity.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient mInstance = new RetrofitClient();
    public static RetrofitClient getInstance(){
        return mInstance;
    }

    private RetrofitClient(){};

    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.upbit.com/v1/market/").addConverterFactory(GsonConverterFactory.create()).build();

    RetrofitService service = retrofit.create(RetrofitService.class);

    public RetrofitService getService(){
        return service;
    }
}
