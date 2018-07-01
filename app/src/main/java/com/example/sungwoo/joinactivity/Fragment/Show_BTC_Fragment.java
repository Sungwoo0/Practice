package com.example.sungwoo.joinactivity.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.sungwoo.joinactivity.R;

public class Show_BTC_Fragment extends Fragment {
    ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.btc_fragment_layout,container,false);
        listView = (ListView)view.findViewById(R.id.btc_listview);
        return view;
    }
}
