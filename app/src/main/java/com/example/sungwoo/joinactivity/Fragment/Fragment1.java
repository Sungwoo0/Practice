package com.example.sungwoo.joinactivity.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment1 extends Fragment {
    ListView listView;
    public static ArrayList<String> coinlist;
    ListviewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout,container,false);

        listView = (ListView)view.findViewById(R.id.listview_coinchart);
        adapter = new ListviewAdapter();
        listView.setAdapter(adapter);
        coinlist = new ArrayList<>();

        Call<ArrayList<CoinData>> rep = RetrofitClient.getInstance().getService().getListCoin();
        rep.enqueue(new Callback<ArrayList<CoinData>>() {
            @Override
            public void onResponse(Call<ArrayList<CoinData>> call, Response<ArrayList<CoinData>> response) {
                if(response != null){
                    for(int i =0 ; i < 271 ; i++) {
                        Log.e("coinlist->", "" + response.body().get(i).getKorean_name().toString() + "," + response.body().get(i).getMarket().toString());
                        coinlist.add(response.body().get(i).getMarket());

                        Log.e("coinlist2 ->", "" + coinlist.get(0));
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

        Call<ArrayList<CoinDetail>> rep2 = RetrofitClient.getInstance().getService().getdetailCoin(coinlist.get(a));
        rep2.enqueue(new Callback<ArrayList<CoinDetail>>() {
            @Override
            public void onResponse(Call<ArrayList<CoinDetail>> call, Response<ArrayList<CoinDetail>> response) {
                if (response != null) {

                    //adapter.addItem(response.body().get(0).getMarket(), "1", response.body().get(0).getChange().toString(),response.body().get(0).getChange());
                    adapter.addItem(response.body().get(0).getMarket(), response.body().get(0).getTrade_price(), response.body().get(0).getChange_rate(),response.body().get(0).getAcc_trade_price_24h());
                    adapter.notifyDataSetChanged();
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



}
