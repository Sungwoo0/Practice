package com.example.sungwoo.joinactivity.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sungwoo.joinactivity.R;

public class Investment1_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.investment1_layout, container, false);
        return view;
    }

    public static Investment1_Fragment newInstance() {
        
        Bundle args = new Bundle();
        
        Investment1_Fragment fragment = new Investment1_Fragment();
        fragment.setArguments(args);
        return fragment;
    }
}
