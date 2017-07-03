package com.example.mypc.retrofitexample.actvity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.constant.ConstantCountry;
import com.example.mypc.retrofitexample.sharedpreference.SharedPreference;

public class SetCountryActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout loVietNam,loThaiLan,loSingapore;
    private ImageView imgSetCounTryExit;
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
        imgSetCounTryExit = (ImageView) findViewById(R.id.imgSetCountryExit);
    }

    private void setEvent() {
        loVietNam.setOnClickListener(this);
        loThaiLan.setOnClickListener(this);
        loSingapore.setOnClickListener(this);
        imgSetCounTryExit.setOnClickListener(this);
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
            case R.id.imgSetCountryExit:
                imgSetCounTryExitButton();
                break;
        }

    }

    private void imgSetCounTryExitButton() {
        finishAffinity();
    }

    private void loSetSingaporeButton() {
        SharedPreference.saveInteger(ConstantCountry.COUNTRY_TYPE.SINGAPORE,SharedPreference.KEY_COUNTRY_ID,this);
        SharedPreference.saveString(ConstantCountry.COUNTRY_TIMEZONE.SINGAPORE,SharedPreference.KEY_TIME_ZONE,this);
        SharedPreference.saveString(ConstantCountry.COUNTRY_NAME.SINGAPORE,SharedPreference.KEY_COUNTRY_NAME,this);
        moveLoginActivity();
    }

    private void loSetThaiLanButton() {
        SharedPreference.saveInteger(ConstantCountry.COUNTRY_TYPE.THAI_LAN,SharedPreference.KEY_COUNTRY_ID,this);
        SharedPreference.saveString(ConstantCountry.COUNTRY_TIMEZONE.THAI_LAN,SharedPreference.KEY_TIME_ZONE,this);
        SharedPreference.saveString(ConstantCountry.COUNTRY_NAME.THAI_LAN,SharedPreference.KEY_COUNTRY_NAME,this);
        moveLoginActivity();
    }

    private void loSetVietNamButton() {
        SharedPreference.saveInteger(ConstantCountry.COUNTRY_TYPE.VIETNAM,SharedPreference.KEY_COUNTRY_ID,this);
        SharedPreference.saveString(ConstantCountry.COUNTRY_TIMEZONE.VIETNAM,SharedPreference.KEY_TIME_ZONE,this);
        SharedPreference.saveString(ConstantCountry.COUNTRY_NAME.VIETNAM,SharedPreference.KEY_COUNTRY_NAME,this);
        moveLoginActivity();
    }

    private void moveLoginActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
