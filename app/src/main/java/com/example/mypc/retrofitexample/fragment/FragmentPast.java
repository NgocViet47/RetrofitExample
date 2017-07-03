package com.example.mypc.retrofitexample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.adapter.RecyclerviewEventAdapter;
import com.example.mypc.retrofitexample.model.Events;
import com.example.mypc.retrofitexample.model.responseResultModel.ResultResponse;
import com.example.mypc.retrofitexample.utils.TimeManager;
import com.example.mypc.retrofitexample.utils.UserManager;
import com.example.mypc.retrofitexample.model.responseResultModel.ResponseEventData;
import com.example.mypc.retrofitexample.repository.CallBackData;
import com.example.mypc.retrofitexample.repository.RepositoryService;
import com.example.mypc.retrofitexample.repository.TicketboxRepository;
import com.example.mypc.retrofitexample.sharedpreference.SharedPreference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPC on 6/7/2017.
 */

public class FragmentPast extends Fragment {
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_past, container, false);
        initialView(view);
        return view;
    }

    private void initialView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.rvListEventPast);
        final List<Events> listEvent = new ArrayList<>();

        StaggeredGridLayoutManager linearLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        final RecyclerviewEventAdapter adapter = new RecyclerviewEventAdapter(listEvent, getContext());
        recyclerView.setAdapter(adapter);
        TicketboxRepository repository = new RepositoryService();
        repository.getEvents(getContext(), SharedPreference.getString(SharedPreference.KEY_TIME_ZONE,getContext()), UserManager.getLastSyncTime(getContext()), new CallBackData<ResultResponse<ResponseEventData>>() {
            @Override
            public void onResponseData(ResultResponse<ResponseEventData> responseEventDataResultResponse) {
                List<Events> eventsList = responseEventDataResultResponse.getData().getEvents();
                for (int i = 0; i < eventsList.size(); i++) {
                    if (TimeManager.getMilliSecondTimeString(eventsList.get(i).getEventEndDate())
                            < TimeManager.getTimeLocalMiliSecond()) {
                        listEvent.add(responseEventDataResultResponse.getData().getEvents().get(i));
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailed(String message) {

            }
        });
    }
}
