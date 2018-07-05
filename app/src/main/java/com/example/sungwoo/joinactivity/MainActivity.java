package com.example.sungwoo.joinactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.sungwoo.joinactivity.Kakao.SessionCallback;

public class MainActivity extends AppCompatActivity {

    private com.kakao.usermgmt.LoginButton btnKakao;
    private SessionCallback callback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.bt_lg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);
            }
        });

        callback = new SessionCallback(); //세션콜백을 부르고
        //Session.getCurrentSession().addCallback(callback); // 추가시키면 끝입니다!!


        btnKakao = (com.kakao.usermgmt.LoginButton) findViewById(R.id.com_kakao_login);


        //com.kakao.auth.Session.getCurrentSession().checkAndImplicitOpen();
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();

    }
}
