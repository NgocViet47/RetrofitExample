package com.example.mypc.retrofitexample.actvity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.constan.ConstanCountry;
import com.example.mypc.retrofitexample.sharedpreference.SharedPreference;

public class SetCountryActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout loVietNam,loThaiLan,loSingapore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_country);
        initialView();
        setEvent();
    }

    private void initialView() {
        loVietNam = (LinearLayout) findViewById(R.id.loVietNam);
        loThaiLan = (LinearLayout) findViewById(R.id.loThaiLan);
        loSingapore = (LinearLayout) findViewById(R.id.loSingapore);
    }

    private void setEvent() {
        loVietNam.setOnClickListener(this);
        loThaiLan.setOnClickListener(this);
        loSingapore.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loVietNam:
                loSetVietNamButton();
                break;
            case R.id.loThaiLan:
                loSetThaiLanButton();
                break;
            case R.id.loSingapore:
                loSetSingaporeButton();
                break;
        }

    }

    private void loSetSingaporeButton() {
        SharedPreference.saveInteger(ConstanCountry.COUNTRY_TYPE.SINGAPORE,SharedPreference.KEY_COUNTRY,this);
        moveLoginActivity();
    }

    private void loSetThaiLanButton() {
        SharedPreference.saveInteger(ConstanCountry.COUNTRY_TYPE.THAILAN,SharedPreference.KEY_COUNTRY,this);
        moveLoginActivity();
    }

    private void loSetVietNamButton() {
        SharedPreference.saveInteger(ConstanCountry.COUNTRY_TYPE.VIETNAM,SharedPreference.KEY_COUNTRY,this);
        moveLoginActivity();
    }

    private void moveLoginActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
