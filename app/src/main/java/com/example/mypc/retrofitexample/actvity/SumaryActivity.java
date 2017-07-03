package com.example.mypc.retrofitexample.actvity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.adapter.MyFragmentPagerAdapter;
import com.example.mypc.retrofitexample.fragment.FragmentOrderList;
import com.example.mypc.retrofitexample.fragment.FragmentSumary;

import java.util.ArrayList;
import java.util.List;

public class SumaryActivity extends BaseActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private Toolbar myToolbar;
    private ViewPager viewPager;
    private LinearLayout loButtonSummary,loButtonbtnOrderList,loButtonCheckInTicket;
    private ImageView imgButtonSummary,imgButtonOrder;
    private TextView tvButtonSummary,tvButtonOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumary);

        inittialView();
        addEvent();
    }

    private void addEvent() {
        loButtonSummary.setOnClickListener(this);
        loButtonbtnOrderList.setOnClickListener(this);
        loButtonCheckInTicket.setOnClickListener(this);
    }

    private void inittialView() {

       /* Bundle bundle = getIntent().getExtras();
        String dataShowing = bundle.getString(BundleExtra.PUT_SHOWING);
        Type type = new TypeToken<ShowingEvent>(){}.getType();
        showingEvent = GeneralMethods.getGson().fromJson(dataShowing,type);*/

        imgButtonSummary = (ImageView) findViewById(R.id.imgButtonSummaryViewCheck);
        imgButtonOrder = (ImageView) findViewById(R.id.imgButtonOrderViewCheck);
        tvButtonSummary = (TextView) findViewById(R.id.tvButtonSummaryViewCheck);
        tvButtonOrder = (TextView) findViewById(R.id.tvButtonOrderViewCheck);

        loButtonSummary = (LinearLayout) findViewById(R.id.loButtonSummary);
        loButtonbtnOrderList = (LinearLayout) findViewById(R.id.loButtonOrderList);
        loButtonCheckInTicket = (LinearLayout) findViewById(R.id.loButtonCheckInTicket);

        viewPager = (ViewPager) findViewById(R.id.viewPagerSummaryAndOrder);

        List<Fragment> listFragment = new ArrayList<>();
        listFragment.add(new FragmentSumary());
        listFragment.add(new FragmentOrderList());

        MyFragmentPagerAdapter myFragmentPagerAdapter =
                new MyFragmentPagerAdapter(getSupportFragmentManager(), listFragment);
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setOnPageChangeListener(this);

        myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setColorButton(int idColorTvSummary, int idColorTvOrder,int imgSummary,int imgOrderList) {
        tvButtonSummary.setTextColor(idColorTvSummary);
        tvButtonOrder.setTextColor(idColorTvOrder);
        imgButtonSummary.setImageResource(imgSummary);
        imgButtonOrder.setImageResource(imgOrderList);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loButtonSummary:
                loButtonSummaryButton();
                break;
            case R.id.loButtonOrderList:
                loButtonbtnOrderListButton();
                break;
            case R.id.loButtonCheckInTicket:
                loButtonCheckInTicketButton();
                break;
        }
    }

    private void loButtonCheckInTicketButton() {
        Intent intent = new Intent(this,ScannerBarcodeActivity.class);
        startActivity(intent);
    }

    private void loButtonbtnOrderListButton() {
        viewPager.setCurrentItem(1);

    }

    private void loButtonSummaryButton() {
        viewPager.setCurrentItem(0);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
            setColorButton(getResources().getColor(R.color.greenTextView)
                    ,getResources().getColor(R.color.gray)
                    ,R.drawable.iconreport
                    ,R.drawable.orderlist);
        } else {
            setColorButton(getResources().getColor(R.color.gray)
                    ,getResources().getColor(R.color.greenTextView)
                    ,R.drawable.reportgray
                    ,R.drawable.orderlistgreen);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
