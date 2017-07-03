package com.example.mypc.retrofitexample.actvity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.adapter.MyFragmentPagerAdapter;
import com.example.mypc.retrofitexample.fragment.FragmentPast;
import com.example.mypc.retrofitexample.fragment.FragmentUpcoming;
import com.example.mypc.retrofitexample.realm.RealmUser;
import com.example.mypc.retrofitexample.utils.UserManager;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class EventActivity extends BaseActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private ViewPager viewPager;
    private TextView tvUpComing, tvPast, tvFullName, tvEmail;
    private LinearLayout loButtonUpComing, loButtonPast ,loButtonLogUot;
    private ImageView imgButtonMenu, imgButtonSearch, imgAvatar;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        initialView();
        loadInfoUser();
        setColorTextview(getResources().getColor(R.color.colorTextViewBlack)
                ,getResources().getColor(R.color.whiteBackground));
        setEvent();

    }

    private void loadInfoUser() {
        tvFullName.setText(UserManager.getUser(this).getFirst_name()
                +" "+UserManager.getUser(this).getLast_name());
        tvEmail.setText(UserManager.getUser(this).getEmail());
        Picasso.with(this).load(UserManager.getUser(this).getAvatar())
                .placeholder(R.color.colorPrimary)
                .fit()
                .centerInside()
                .noFade()
                .tag(this)
                .into(imgAvatar);
    }

    private void setEvent() {
        loButtonUpComing.setOnClickListener(this);
        loButtonPast.setOnClickListener(this);
        imgButtonMenu.setOnClickListener(this);
        imgButtonSearch.setOnClickListener(this);
        loButtonLogUot.setOnClickListener(this);
    }

    private void initialView() {

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        imgButtonMenu = (ImageView) findViewById(R.id.imgButtonMenuEvent);
        imgButtonSearch = (ImageView) findViewById(R.id.imgButtonSearchEvent);
        imgAvatar = (ImageView) findViewById(R.id.imgAvatarUserEvent);

        tvUpComing = (TextView) findViewById(R.id.tvUpComingEvent);
        tvPast = (TextView) findViewById(R.id.tvPastEvent);
        tvFullName = (TextView) findViewById(R.id.tvFullNameUserEvent);
        tvEmail = (TextView) findViewById(R.id.tvEmailUserEvent);

        loButtonPast = (LinearLayout) findViewById(R.id.loButtonPastEvent);
        loButtonUpComing = (LinearLayout) findViewById(R.id.loButtonUpComingEvent);
        loButtonLogUot = (LinearLayout) findViewById(R.id.loButtonLogUot);

        viewPager = (ViewPager) findViewById(R.id.viewPagerEvent);
        List<Fragment> listFragment = new ArrayList<>();
        listFragment.add(new FragmentUpcoming());
        listFragment.add(new FragmentPast());

        MyFragmentPagerAdapter myFragmentPagerAdapter =
                new MyFragmentPagerAdapter(getSupportFragmentManager(), listFragment);
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setOnPageChangeListener(this);
        onRestart();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
            setColorTextview(getResources().getColor(R.color.colorTextViewBlack)
                    ,getResources().getColor(R.color.whiteBackground));
        } else {
            setColorTextview(getResources().getColor(R.color.whiteBackground)
                    ,getResources().getColor(R.color.colorTextViewBlack));
        }
    }

    private void setColorTextview(int idColorTvUpComing, int idColorTvPast) {
        tvUpComing.setTextColor(idColorTvUpComing);
        tvPast.setTextColor(idColorTvPast);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loButtonPastEvent:
                loButtonPastButton();
                break;
            case R.id.loButtonUpComingEvent:
                loButtonUpComingButton();
                break;
            case R.id.imgButtonMenuEvent:
                imgButtonMenuButton();
                break;
            case R.id.imgButtonSearchEvent:
                imgButtonSearchButton();
                break;
            case R.id.loButtonLogUot:
                loButtonLogUotButton();
                break;
        }
    }

    private void loButtonLogUotButton() {
        RealmUser.clearUser(this);
        Intent intent = new Intent(this, SetCountryActivity.class);
        startActivity(intent);
        finish();
    }

    private void imgButtonSearchButton() {
        Intent intent = new Intent(this,SearchActivity.class);
        startActivity(intent);
    }

    private void imgButtonMenuButton() {
        drawerLayout.openDrawer(Gravity.LEFT);
    }

    private void loButtonUpComingButton() {
        viewPager.setCurrentItem(1);
    }

    private void loButtonPastButton() {
        viewPager.setCurrentItem(0);
    }
}
