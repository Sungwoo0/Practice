package com.example.sungwoo.joinactivity.Retrofit;

import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("/all")
    Call<ArrayList<JsonObject>> getListCoin();
}
