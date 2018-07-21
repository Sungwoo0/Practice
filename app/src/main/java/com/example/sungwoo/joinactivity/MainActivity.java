package com.example.sungwoo.joinactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.LoginButton;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.exception.KakaoException;

public class MainActivity extends AppCompatActivity {

    private LoginButton btnKakao;
    private SessionCallback callback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.bt_lg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }
        });

        callback = new SessionCallback(); //세션콜백을 부르고
        Session.getCurrentSession().addCallback(callback); // 추가시키면 끝입니다!!

        btnKakao = (LoginButton) findViewById(R.id.com_kakao_login);
        btnKakao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnKakao.performClick();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //간편로그인시 호출 ,없으면 간편로그인시 로그인 성공화면으로 넘어가지 않음
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    private class SessionCallback implements ISessionCallback {
        @Override
        public void onSessionOpened() {
            KakaorequestMe();
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            if (exception != null) {
                Log.d("ErrorSession", exception.getMessage());
            }
        }


        public void KakaorequestMe() {
            UserManagement.requestMe(new MeResponseCallback() {

                @Override
                public void onFailure(ErrorResult errorResult) {
                    Log.d("Error", "오류로 카카오로그인 실패 ");
                }

                @Override
                public void onSessionClosed(ErrorResult errorResult) {
                    Log.d("Error", "오류로 카카오로그인 실패 ");
                }

                @Override
                public void onNotSignedUp() {
                }

                @Override
                public void onSuccess(UserProfile userProfile) {
                    //로그인에 성공하면 로그인한 사용자의 일련번호, 닉네임, 이미지url등을 리턴합니다.
                    //사용자 ID는 보안상의 문제로 제공하지 않고 일련번호는 제공합니다.

                    //이곳에서 로그인이 완료될시 실행시킬 동작을 추가시켜주시면 됩니다 ~

                    Log.e("UserProfile", userProfile.toString());
                    if (Session.getCurrentSession().isOpened() != false) {
                        Log.e("Login state!", "로그인되어있음");
                        Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                        startActivity(intent);
                    } else {
                        Log.e("Login state!", "로그인");
                    }
                }
            });
        }
    }
}



