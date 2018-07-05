package com.example.sungwoo.joinactivity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sungwoo.joinactivity.Model.Listview_CoinData;
import com.example.sungwoo.joinactivity.R;

import java.util.ArrayList;

public class ListviewAdapter extends BaseAdapter {

    TextView coinname;
    TextView coinprice;
    TextView coinincrement;
    TextView cointradingvalue;

    ArrayList<Listview_CoinData> listview_item_list = new ArrayList<>();
    @Override
    public int getCount() {
        return listview_item_list.size();
    }

    @Override
    public Object getItem(int position) {
        return listview_item_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos = position;
        final Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.customlistview_layout, parent,false);
        }

        coinname = (TextView)convertView.findViewById(R.id.coinname);
        coinprice = (TextView)convertView.findViewById(R.id.coinprice);
        coinincrement = (TextView)convertView.findViewById(R.id.coinincrement);
        cointradingvalue = (TextView)convertView.findViewById(R.id.cointradingvalue);

        Listview_CoinData listview_coinData = listview_item_list.get(position);

        coinname.setText(listview_coinData.getCoin_name());
        coinprice.setText(String.valueOf(listview_coinData.getCoin_currentprice()));
        coinincrement.setText(String.valueOf(listview_coinData.getCoin_change()));
        cointradingvalue.setText(String.valueOf(listview_coinData.getCoin_transaction_value()));


        return convertView;
    }

    public void addItem(String name, double price, double increment, double tradingvalue) {
        Listview_CoinData item = new Listview_CoinData();

        item.setCoin_name(name);
        item.setCoin_currentprice(price);
        item.setCoin_change(increment);
        item.setCoin_transaction_value(tradingvalue);

        listview_item_list.add(item);
    }

}
