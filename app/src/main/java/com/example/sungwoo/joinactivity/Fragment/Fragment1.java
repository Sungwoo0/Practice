package com.example.sungwoo.joinactivity.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.sungwoo.joinactivity.Adapter.ListviewAdapter;
import com.example.sungwoo.joinactivity.R;

import java.util.ArrayList;

public class Fragment1 extends Fragment {
    ListView listView;
    public static ArrayList<String> coinlist;
    ListviewAdapter adapter;
    FrameLayout frameLayout;
    Button show_krw_btn;
    Button show_btc_btn;
    Button show_eth_btn;
    Button show_usdt_btn;

    SearchView searchView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout,container,false);

        frameLayout = (FrameLayout)view.findViewById(R.id.framelayout_listview);
        coinlist = new ArrayList<>();

        searchView = (SearchView)view.findViewById(R.id.searchbar_coinlist);

        show_krw_btn = (Button)view.findViewById(R.id.fragment_btn1);
        show_btc_btn = (Button)view.findViewById(R.id.fragment_btn2);
        show_eth_btn = (Button)view.findViewById(R.id.fragment_btn3);
        show_usdt_btn = (Button)view.findViewById(R.id.fragment_btn4);

        getFragmentManager().beginTransaction().replace(R.id.framelayout_listview, new Show_KRW_Fragment()).commit();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        show_krw_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.framelayout_listview, new Show_KRW_Fragment()).commit();
            }
        });

        show_btc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.framelayout_listview, new Show_BTC_Fragment()).commit();
            }
        });

        show_eth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.framelayout_listview, new Show_ETH_Fragment()).commit();
            }
        });

        show_usdt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.framelayout_listview, new Show_USDT_Fragment()).commit();
            }
        });
        return view;
    }
}
