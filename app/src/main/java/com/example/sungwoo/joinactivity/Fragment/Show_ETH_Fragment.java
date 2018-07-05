package com.example.sungwoo.joinactivity.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.sungwoo.joinactivity.Adapter.ListviewAdapter;
import com.example.sungwoo.joinactivity.Model.CoinData;
import com.example.sungwoo.joinactivity.Model.CoinDetail;
import com.example.sungwoo.joinactivity.R;
import com.example.sungwoo.joinactivity.Retrofit.RetrofitClient;

import java.math.BigDecimal;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Show_ETH_Fragment extends Fragment {
    ListView listView;
    ListviewAdapter adapter;
    public static ArrayList<String> coinlist_eth;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.eth_fragment_layout,container,false);
        listView = (ListView)view.findViewById(R.id.eth_listview);
        adapter = new ListviewAdapter();
        listView.setAdapter(adapter);
        coinlist_eth = new ArrayList<>();

        Call<ArrayList<CoinData>> rep = RetrofitClient.getInstance().getService().getListCoin();
        rep.enqueue(new Callback<ArrayList<CoinData>>() {
            @Override
            public void onResponse(Call<ArrayList<CoinData>> call, Response<ArrayList<CoinData>> response) {
                if(response != null){
                    for(int i =0 ; i < response.body().size() ; i++) {
                        coinlist_eth.add(response.body().get(i).getMarket());
                        getCoinDetails(i);
                    }
                }else{
                    Log.e("onresponse null","dd");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<CoinData>> call, Throwable t) {
                Log.e("onfailure called->",""+t.toString());
            }
        });
        return view;
    }

    public void getCoinDetails(int a){
        Call<ArrayList<CoinDetail>> rep2 = RetrofitClient.getInstance().getService().getdetailCoin(coinlist_eth.get(a));
        rep2.enqueue(new Callback<ArrayList<CoinDetail>>() {
            @Override
            public void onResponse(Call<ArrayList<CoinDetail>> call, Response<ArrayList<CoinDetail>> response) {
                if (response != null) {
                    double change_rate;
                    change_rate = response.body().get(0).getChange_rate() * 100;
                    double change_rate2 = Double.parseDouble(String.format("%.2f",change_rate));

                    double trade_price;
                    trade_price = response.body().get(0).getAcc_trade_price_24h();
                    BigDecimal trade_price2 = new BigDecimal(trade_price);
                    double trade_price3 = trade_price2.doubleValue();
                    long trade_price4 = Math.round(trade_price3);

                    if(getCoinMarket(response.body().get(0).getMarket()).equals("ETH")){
                        adapter.addItem(response.body().get(0).getMarket(), response.body().get(0).getTrade_price(),
                                change_rate2, trade_price4);
                        adapter.notifyDataSetChanged();
                    }

                } else {
                    Log.e("onResponse error", "null");
                }
            }
            @Override
            public void onFailure(Call<ArrayList<CoinDetail>> call, Throwable t) {
                Log.e("onFailure Called", "" + t.toString());
            }
        });
    }

    public String getCoinMarket(String market){
        int index = market.indexOf("-");
        String market2 = market.substring(0,index);
        return market2;
    }
}
