package com.example.sungwoo.joinactivity.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sungwoo.joinactivity.Adapter.TabPagerAdapter;
import com.example.sungwoo.joinactivity.R;

public class Fragment2 extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment2_layout,container,false);
        tabLayout = (TabLayout)view.findViewById(R.id.main_tablayout);
        viewPager = (ViewPager)view.findViewById(R.id.viewpager);

        tabLayout.addTab(tabLayout.newTab().setText("보유코인"));
        tabLayout.addTab(tabLayout.newTab().setText("거래내역"));
        tabLayout.addTab(tabLayout.newTab().setText("미체결"));

        TabPagerAdapter adapter = new TabPagerAdapter(getFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        return view;
    }
}
