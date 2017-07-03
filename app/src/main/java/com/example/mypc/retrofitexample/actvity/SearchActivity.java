package com.example.mypc.retrofitexample.actvity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.adapter.RecyclerviewEventAdapter;
import com.example.mypc.retrofitexample.model.Events;
import com.example.mypc.retrofitexample.model.responseResultModel.ResponseEventData;
import com.example.mypc.retrofitexample.model.responseResultModel.ResultResponse;
import com.example.mypc.retrofitexample.repository.CallBackData;
import com.example.mypc.retrofitexample.repository.RepositoryService;
import com.example.mypc.retrofitexample.repository.TicketboxRepository;
import com.example.mypc.retrofitexample.utils.UserManager;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends BaseActivity implements View.OnClickListener {

    private SearchView searchView;
    private RecyclerView recyclerView;
    private List<Events> listEvent = new ArrayList<>();
    private String timeZone = "+07:00";
    private RecyclerviewEventAdapter adapter;
    private ImageView imgButtonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initialView();
        setEvent();

    }

    private void setEvent() {
        imgButtonBack.setOnClickListener(this);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });
    }

    private void initialView() {
        imgButtonBack = (ImageView) findViewById(R.id.imgButtonBackSearch);
        searchView = (SearchView) findViewById(R.id.searchView);
        recyclerView = (RecyclerView) findViewById(R.id.rvListEventSearch);

        StaggeredGridLayoutManager linearLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new RecyclerviewEventAdapter(listEvent, this);
        recyclerView.setAdapter(adapter);

        TicketboxRepository repository = new RepositoryService();
        repository.getEvents(this, timeZone, UserManager.getLastSyncTime(this), new CallBackData<ResultResponse<ResponseEventData>>() {
            @Override
            public void onResponseData(ResultResponse<ResponseEventData> responseEventDataResultResponse) {
                List<Events> eventsList = responseEventDataResultResponse.getData().getEvents();
                for (int i = 0; i < eventsList.size(); i++) {
                    listEvent.add(eventsList.get(i));
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailed(String message) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgButtonBackSearch:
                buttonBackEvent();
                break;
        }
    }

    private void buttonBackEvent() {
        finish();
    }
}
