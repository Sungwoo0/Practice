package com.example.sungwoo.joinactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_id, et_pw;
    Button login_btn;

    String input_id;
    String input_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_id = "psw";
        input_password = "psw";

        et_id = (EditText) findViewById(R.id.et_Id);
        et_pw = (EditText) findViewById(R.id.et_Password);
        login_btn = (Button)findViewById(R.id.bt_Join);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_id.getText().toString().equals(input_id) && et_pw.getText().toString().equals(input_password) ) {


                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "틀림", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
