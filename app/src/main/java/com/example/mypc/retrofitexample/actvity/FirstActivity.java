package com.example.mypc.retrofitexample.actvity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.utils.TimeManager;
import com.example.mypc.retrofitexample.realm.RealmUser;
import com.example.mypc.retrofitexample.sharedpreference.SharedPreference;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        checkLogged();
    }
    private void checkLogged() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {

                if(RealmUser.getUser(getApplicationContext())!=null&&
                        SharedPreference.getLong(SharedPreference.KEY_START_TIME,getApplicationContext())
                                > TimeManager.getTimeLocalMiliSecond()){
                    Intent intent = new Intent(getApplicationContext(),EventActivity.class);
                    startActivity(intent);
                }else {
                    RealmUser.clearUser(getApplicationContext());
                    Log.e("Clear","Realm");
                    Intent intent = new Intent(getApplicationContext(),SetCountryActivity.class);
                    startActivity(intent);
                }
                /*Intent intent = new Intent(getApplicationContext(),SetCountryActivity.class);
                startActivity(intent);*/
            }
        }, 3000);

    }

}
