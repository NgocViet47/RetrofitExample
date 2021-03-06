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
import com.example.mypc.retrofitexample.adapter.RecyclerviewOrderAdapter;
import com.example.mypc.retrofitexample.constant.ConstantCheckIn;
import com.example.mypc.retrofitexample.model.Order;
import com.example.mypc.retrofitexample.model.OrderAndNumberTicket;
import com.example.mypc.retrofitexample.model.ShowingEvent;
import com.example.mypc.retrofitexample.model.Ticket;
import com.example.mypc.retrofitexample.model.responseResultModel.ResponseOrderShowInData;
import com.example.mypc.retrofitexample.model.responseResultModel.ResultResponse;
import com.example.mypc.retrofitexample.putextra.BundleExtra;
import com.example.mypc.retrofitexample.repository.CallBackData;
import com.example.mypc.retrofitexample.repository.RepositoryService;
import com.example.mypc.retrofitexample.repository.TicketboxRepository;
import com.example.mypc.retrofitexample.retrofit.GeneralMethods;
import com.example.mypc.retrofitexample.sharedpreference.SharedPreference;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPC on 6/20/2017.
 */

public class FragmentCheckIn extends Fragment {
    private RecyclerView recyclerView;
    private ResponseOrderShowInData responseOrderShowInData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkin, container, false);
        initialView(view);
        return view;
    }

    private void initialView(View view) {
        Bundle bundle = getActivity().getIntent().getExtras();
        String dataShowing = bundle.getString(BundleExtra.PUT_SHOWING);
        Type type = new TypeToken<ShowingEvent>() {
        }.getType();
        ShowingEvent showingEvent = GeneralMethods.getGson().fromJson(dataShowing, type);

        recyclerView = (RecyclerView) view.findViewById(R.id.rvCheckIn);
        StaggeredGridLayoutManager linearLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        TicketboxRepository repository = new RepositoryService();
        repository.getShowInOrder(getContext(), showingEvent.getShowingId(), SharedPreference.getString(SharedPreference.KEY_TIME_ZONE, getContext()), new CallBackData<ResultResponse<ResponseOrderShowInData>>() {
            @Override
            public void onResponseData(ResultResponse<ResponseOrderShowInData> responseOrderShowInDataResultResponse) {
                responseOrderShowInData = responseOrderShowInDataResultResponse.getData();

                List<Order> orderList = responseOrderShowInData.getCurrentShowing().getOrders();
                List<Ticket> ticketList = responseOrderShowInData.getCurrentShowing().getTickets();
                List<OrderAndNumberTicket> orderAndNumberTicketList = new ArrayList<>();
                for (int i = 0; i < orderList.size(); i++) {
                    int numberTicket = 0;
                    for (int j = 0; j < ticketList.size(); j++) {
                        if (ticketList.get(j).getOrderId().equals(orderList.get(i).getOrderId())) {
                            if (ticketList.get(j).getStatus().equals(ConstantCheckIn.CHECK_IN)) {
                                numberTicket++;
                                }
                        }
                    }
                    if (numberTicket > 0) {
                        orderAndNumberTicketList.add(new OrderAndNumberTicket(orderList.get(i), numberTicket));
                    }
                }
                final RecyclerviewOrderAdapter adapter = new RecyclerviewOrderAdapter(orderAndNumberTicketList, getContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailed(String message) {

            }
        });

    }
}
