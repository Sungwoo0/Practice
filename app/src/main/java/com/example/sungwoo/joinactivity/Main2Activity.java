package com.example.sungwoo.joinactivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.sungwoo.joinactivity.Fragment.Fragment1;
import com.example.sungwoo.joinactivity.Fragment.Fragment2;
import com.example.sungwoo.joinactivity.Fragment.Fragment3;
import com.example.sungwoo.joinactivity.Fragment.Fragment4;

public class Main2Activity extends AppCompatActivity {

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        frameLayout = (FrameLayout)findViewById(R.id.main_frame);
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new Fragment1()).commit();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedfragment = null;
                switch (item.getItemId()) {
                    case R.id.action_one:
                        selectedfragment = new Fragment1();
                        break;
                    case R.id.action_two:
                        selectedfragment = new Fragment2();
                        break;
                    case R.id.action_three:
                        selectedfragment = new Fragment3();
                        break;
                    case R.id.action_four:
                        selectedfragment = new Fragment4();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, selectedfragment).commit();
                return true;
            }
        });
    }
}
