package com.example.mypc.retrofitexample.actvity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.adapter.RecyclerviewShowingAdapter;
import com.example.mypc.retrofitexample.model.ShowingEvent;
import com.example.mypc.retrofitexample.model.responseResultModel.ResultResponse;
import com.example.mypc.retrofitexample.putextra.BundleExtra;
import com.example.mypc.retrofitexample.repository.CallBackData;
import com.example.mypc.retrofitexample.repository.RepositoryService;
import com.example.mypc.retrofitexample.repository.TicketboxRepository;
import com.example.mypc.retrofitexample.sharedpreference.SharedPreference;

import java.util.ArrayList;
import java.util.List;

public class ShowingActivity extends BaseActivity {

    private RecyclerView rvListShowing;
    private TextView tvTimeZone;
    private List<ShowingEvent> showingList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showing);

        initialView();
    }

    private void initialView() {

        tvTimeZone = (TextView) findViewById(R.id.tvTimeZone);
        tvTimeZone.setText("Time zone: "+SharedPreference.getString(SharedPreference.KEY_COUNTRY_NAME,this)+
                " time "+"(GMT "+SharedPreference.getString(SharedPreference.KEY_TIME_ZONE,this)+")");

        Bundle bundle = getIntent().getExtras();
        int eventId = bundle.getInt(BundleExtra.PUT_EVENTID);

        rvListShowing = (RecyclerView) findViewById(R.id.rvListShowing);
        final StaggeredGridLayoutManager linearLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rvListShowing.setLayoutManager(linearLayoutManager);

        final RecyclerviewShowingAdapter adapter = new RecyclerviewShowingAdapter(showingList,this);
        rvListShowing.setAdapter(adapter);

        TicketboxRepository ticketboxRepository = new RepositoryService();
        ticketboxRepository.getShowingByEventId(this, eventId, SharedPreference.getString(SharedPreference.KEY_TIME_ZONE, this), new CallBackData<ResultResponse<List<ShowingEvent>>>() {
            @Override
            public void onResponseData(ResultResponse<List<ShowingEvent>> listResultResponse) {
                if(listResultResponse.getData().size()>0) {
                    for (int i = 0; i < listResultResponse.getData().size(); i++) {
                        showingList.add(listResultResponse.getData().get(i));
                        adapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailed(String message) {

            }
        });

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
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
}
