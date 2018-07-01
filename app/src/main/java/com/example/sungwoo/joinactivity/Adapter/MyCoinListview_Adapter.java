package com.example.sungwoo.joinactivity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sungwoo.joinactivity.Model.ListView_myCoinData;
import com.example.sungwoo.joinactivity.R;

import java.util.ArrayList;

public class MyCoinListview_Adapter extends BaseAdapter {

    ArrayList<ListView_myCoinData> myCoinDataArrayList = new ArrayList<>();
    @Override
    public int getCount() {
        return myCoinDataArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return myCoinDataArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.mycoinlistview_layout, parent,false);
        }

        ImageView mycoinImageview = (ImageView)convertView.findViewById(R.id.mycoin_imageview);
        TextView mycoinTextView = (TextView)convertView.findViewById(R.id.mycoin_name);
        TextView myassetsTextView = (TextView)convertView.findViewById(R.id.mycoin_assets);
        TextView coinenglishname = (TextView)convertView.findViewById(R.id.english_coinname);

        ListView_myCoinData listview_coinData = myCoinDataArrayList.get(position);

        mycoinTextView.setText(listview_coinData.getMoney_name());
        myassetsTextView.setText(String.valueOf(listview_coinData.getMoney_quantity()));
        mycoinImageview.setImageResource(listview_coinData.getCoinimage());
        coinenglishname.setText(listview_coinData.getEn_money_name());

        return convertView;
    }

    public String getcoinname(int position){
        return myCoinDataArrayList.get(position).getEn_money_name();
    }

    public void addItem(int coinimage, String coin_name, String en_coin_name, double assets) {
        ListView_myCoinData item = new ListView_myCoinData();

        item.setCoinimage(coinimage);
        item.setMoney_name(coin_name);
        item.setMoney_quantity(assets);
        item.setEn_money_name(en_coin_name);

        myCoinDataArrayList.add(item);
    }


}
