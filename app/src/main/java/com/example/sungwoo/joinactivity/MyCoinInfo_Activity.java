package com.example.sungwoo.joinactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MyCoinInfo_Activity extends AppCompatActivity {
    TextView textView_cointitle;
    TextView textView_coinname1;
    TextView textView_coinname2;
    TextView textView_coinname3;
    TextView textView_coinname4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_coin_info);

        textView_cointitle = (TextView)findViewById(R.id.cointitle_textview);
        textView_coinname1 = (TextView)findViewById(R.id.coinname_textview);
        textView_coinname2 = (TextView)findViewById(R.id.coinname_textview2);
        textView_coinname3 = (TextView)findViewById(R.id.coinname_textview3);
        textView_coinname4 = (TextView)findViewById(R.id.coinname_textview4);

        Intent intent = getIntent(); // 보내온 Intent를 얻는다
        textView_cointitle.setText(intent.getStringExtra("coinname")+"입출금");
        textView_coinname1.setText(intent.getStringExtra("coinname"));
        textView_coinname2.setText(intent.getStringExtra("coinname"));
        textView_coinname3.setText(intent.getStringExtra("coinname"));
        textView_coinname4.setText(intent.getStringExtra("coinname")+" "+"입출금 내역");
    }
}
