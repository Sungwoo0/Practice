package com.example.sungwoo.joinactivity.Retrofit;

import com.example.sungwoo.joinactivity.Model.CoinData;
import com.example.sungwoo.joinactivity.Model.CoinDetail;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("market/all")
    Call<ArrayList<CoinData>> getListCoin();
//    https://api.upbit.com/v1/market/all
//    https://api.upbit.com/v1/ticker?markets=KRW-BTC
    @GET("ticker")
    Call<ArrayList<CoinDetail>> getdetailCoin(@Query("markets") String coinname);
}
