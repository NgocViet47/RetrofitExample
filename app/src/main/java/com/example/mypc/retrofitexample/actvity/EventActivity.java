package com.example.mypc.retrofitexample.actvity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TabHost;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.adapter.MyFragmentPagerAdapter;
import com.example.mypc.retrofitexample.fragment.FragmentPast;
import com.example.mypc.retrofitexample.fragment.FragmentUpcoming;

import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {

    private TabHost tabHost;
    private ViewPager viewPager;

    class FakeContent implements TabHost.TabContentFactory {
        private final Context mContext;

        public FakeContent(Context context) {
            mContext = context;
        }

        @Override
        public View createTabContent(String tag) {
            View v = new View(mContext);
            v.setMinimumHeight(0);
            v.setMinimumWidth(0);
            return v;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        initializeTabHost(savedInstanceState);
        initialView();

    }

    private void initializeTabHost(Bundle savedInstanceState) {
        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();


        TabHost.TabSpec tabUpcoming;
        tabUpcoming = tabHost.newTabSpec("Upcoming");
        tabUpcoming.setIndicator("Upcoming");
        tabUpcoming.setContent(new FakeContent(this));

        TabHost.TabSpec tabPast;
        tabPast = tabHost.newTabSpec("Past");
        tabPast.setIndicator("Past");
        tabPast.setContent(new FakeContent(this));

        tabHost.addTab(tabUpcoming);
        tabHost.addTab(tabPast);
        tabHost.setOnTabChangedListener(this);
    }

    private void initialView() {
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
        tabHost.setCurrentTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabChanged(String tabId) {

    }
}
