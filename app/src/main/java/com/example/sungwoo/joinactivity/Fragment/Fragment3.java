package com.example.sungwoo.joinactivity.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sungwoo.joinactivity.Adapter.MyCoinListview_Adapter;
import com.example.sungwoo.joinactivity.MyCoinInfo_Activity;
import com.example.sungwoo.joinactivity.R;

public class Fragment3 extends Fragment {
    ListView listView;
    MyCoinListview_Adapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3_layout, container, false);
        listView = (ListView)view.findViewById(R.id.mycoin_listview);
        adapter = new MyCoinListview_Adapter();
        listView.setAdapter(adapter);

        adapter.addItem(R.drawable.krw, "원화","KRW",123);
        adapter.addItem(R.drawable.btc, "비트코인","BTC",123);
        adapter.addItem(R.drawable.eth, "이더리움","ETH",123);
        adapter.addItem(R.drawable.etc, "이더리움클래식","ETC",123);
        adapter.addItem(R.drawable.dash, "대시","DASH",123);
        adapter.addItem(R.drawable.ltc, "라이트코인","LTC",123);
        adapter.addItem(R.drawable.lsk, "리스크","LSK",123);
        adapter.addItem(R.drawable.xrp, "리플","XRP",123);
        adapter.addItem(R.drawable.xmr, "모네로","XMR",123);
        adapter.addItem(R.drawable.bch, "비트코인캐시","BCH",123);
        adapter.addItem(R.drawable.steem, "스팀","STEEM",123);
        adapter.addItem(R.drawable.waves, "웨이브","WAVES",123);
        adapter.addItem(R.drawable.zec, "지캐시","ZEC",123);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), MyCoinInfo_Activity.class);

                Toast.makeText(getActivity(), ""+adapter.getcoinname(position), Toast.LENGTH_SHORT).show();
                intent.putExtra("coinname", adapter.getcoinname(position));
                startActivity(intent);
            }
        });


        return view;
    }
}
