package com.example.sungwoo.joinactivity.Adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.sungwoo.joinactivity.Fragment.Investment1_Fragment;
import com.example.sungwoo.joinactivity.Fragment.Investment2_Fragment;
import com.example.sungwoo.joinactivity.Fragment.Investment3_Fragment;

public class TabPagerAdapter extends FragmentStatePagerAdapter{

    private int tabNum;

    public TabPagerAdapter(FragmentManager fm, int tabNum) {
        super(fm);
        this.tabNum = tabNum;
    }

    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0:
                Investment1_Fragment investment1_fragment = new Investment1_Fragment();
                return investment1_fragment;
            case 1:
                Investment2_Fragment investment2_fragment = new Investment2_Fragment();
                return investment2_fragment;
            case 2:
                Investment3_Fragment investment3_fragment = new Investment3_Fragment();
                return investment3_fragment;
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return tabNum;
    }
}
