package com.example.mypc.retrofitexample.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.adapter.MyFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPC on 6/20/2017.
 */

public class FragmentOrderList extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private ViewPager viewPagerOrder;
    private LinearLayout loAllOrder, loNotCheckIn, loCheckIn;
    private FragmentActivity myContext;
    private TextView tvAllOrder, tvOrderNotCheckIn, tvOrderCheckIn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_oder_list, container, false);
        initialView(view);
        addEvent();
        setColorButton(getResources().getColor(R.color.greenTextView), R.drawable.linearlayout_button_order_green
                , getResources().getColor(R.color.gray), R.drawable.linearlayout_button_order_gray
                , getResources().getColor(R.color.gray), R.drawable.linearlayout_button_order_gray
        );
        return view;
    }

    private void addEvent() {
        loAllOrder.setOnClickListener(this);
        loCheckIn.setOnClickListener(this);
        loNotCheckIn.setOnClickListener(this);

        viewPagerOrder.setOnPageChangeListener(this);
    }

    @Override
    public void onAttach(Activity activity) {
        myContext = (FragmentActivity) activity;
        super.onAttach(activity);
    }

    private void initialView(View view) {

        tvAllOrder = (TextView) view.findViewById(R.id.tvOrderAll);
        tvOrderCheckIn = (TextView) view.findViewById(R.id.tvOrderCheckIn);
        tvOrderNotCheckIn = (TextView) view.findViewById(R.id.tvOrderNotCheckIn);

        viewPagerOrder = (ViewPager) view.findViewById(R.id.viewPagerOrder);
        loAllOrder = (LinearLayout) view.findViewById(R.id.loButtonOrderAll);
        loCheckIn = (LinearLayout) view.findViewById(R.id.loButtonOrderCheckIn);
        loNotCheckIn = (LinearLayout) view.findViewById(R.id.loButtonOrderNotCheckIn);

        List<Fragment> listFragment = new ArrayList<>();
        listFragment.add(new FragmentAllOrder());
        listFragment.add(new FragmentNotCheckIn());
        listFragment.add(new FragmentCheckIn());

        FragmentManager fragManager = myContext.getSupportFragmentManager();

        MyFragmentPagerAdapter myFragmentPagerAdapter =
                new MyFragmentPagerAdapter(fragManager, listFragment);
        viewPagerOrder.setAdapter(myFragmentPagerAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loButtonOrderAll:
                loAllOrderButton();
                break;
            case R.id.loButtonOrderNotCheckIn:
                loNotCheckInButton();
                break;
            case R.id.loButtonOrderCheckIn:
                loCheckInButton();
                break;
        }
    }

    private void loCheckInButton() {
        viewPagerOrder.setCurrentItem(2);
    }

    private void loNotCheckInButton() {
        viewPagerOrder.setCurrentItem(1);
    }

    private void loAllOrderButton() {
        viewPagerOrder.setCurrentItem(0);
    }

    private void setColorButton(int idTextViewAll, int idBackgroundall, int idTextViewNotCheckIn
            , int idBackgroundNotCheckIn, int idTextViewCheckIn, int idBackgroundCheckIn) {
        tvAllOrder.setTextColor(idTextViewAll);
        tvOrderNotCheckIn.setTextColor(idTextViewNotCheckIn);
        tvOrderCheckIn.setTextColor(idTextViewCheckIn);
        loAllOrder.setBackgroundResource(idBackgroundall);
        loNotCheckIn.setBackgroundResource(idBackgroundNotCheckIn);
        loCheckIn.setBackgroundResource(idBackgroundCheckIn);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
            setColorButton(getResources().getColor(R.color.greenTextView), R.drawable.linearlayout_button_order_green
                    , getResources().getColor(R.color.gray), R.drawable.linearlayout_button_order_gray
                    , getResources().getColor(R.color.gray), R.drawable.linearlayout_button_order_gray
            );
        } else if (position == 1) {
            setColorButton(getResources().getColor(R.color.gray), R.drawable.linearlayout_button_order_gray
                    , getResources().getColor(R.color.greenTextView), R.drawable.linearlayout_button_order_green
                    , getResources().getColor(R.color.gray), R.drawable.linearlayout_button_order_gray
            );
        } else {
            setColorButton(getResources().getColor(R.color.gray), R.drawable.linearlayout_button_order_gray
                    , getResources().getColor(R.color.gray), R.drawable.linearlayout_button_order_gray
                    , getResources().getColor(R.color.greenTextView), R.drawable.linearlayout_button_order_green
            );
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
