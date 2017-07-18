package com.example.mypc.retrofitexample.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import com.example.mypc.retrofitexample.model.Ticket;
import com.example.mypc.retrofitexample.model.TicketCheck;
import com.example.mypc.retrofitexample.model.responseResultModel.ResponseOrderShowInData;
import com.example.mypc.retrofitexample.model.responseResultModel.ResultResponse;
import com.example.mypc.retrofitexample.repository.CallBackData;
import com.example.mypc.retrofitexample.repository.RepositoryService;
import com.example.mypc.retrofitexample.repository.TicketboxRepository;
import com.example.mypc.retrofitexample.sharedpreference.SharedPreference;
import com.example.mypc.retrofitexample.utils.CurrentShowingManager;
import com.example.mypc.retrofitexample.utils.OrderManager;
import com.example.mypc.retrofitexample.utils.TicketManager;
import com.example.mypc.retrofitexample.utils.TicketTypeManager;

import java.util.ArrayList;
import java.util.List;

public class ServiceUpdateTicket extends Service {
    private Handler handler;
    private Runnable runnable;
    private List<TicketCheck> listTicket = new ArrayList<>();

    public ServiceUpdateTicket() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("AutoReplay", "Auto");
        handler = new Handler();
        runnable = new Runnable() {
            public void run() {

                Log.e("AutoReplay", "Auto");
                checkInListTicket();
                updateTicketNewCheckIn();
                handler.postDelayed(runnable, 10000);
            }
        };
        handler.postDelayed(runnable, 1000);

    }

    private void updateTicketNewCheckIn() {
        if(listTicket.size()!=0) {

            TicketboxRepository ticketboxRepository = new RepositoryService();
            ticketboxRepository.postTicketCheckIn(this, CurrentShowingManager.getListCurrentShowing(this).getShowingId()
                    , SharedPreference.getString(SharedPreference.KEY_TIME_ZONE, this)
                    , listTicket
                    , new CallBackData<ResultResponse<ResponseOrderShowInData>>() {
                        @Override
                        public void onResponseData(ResultResponse<ResponseOrderShowInData> responseOrderShowInDataResultResponse) {
                            clearRealmShowIng();
                            CurrentShowingManager.createCurrentShowing(getApplicationContext(), responseOrderShowInDataResultResponse.getData().getCurrentShowing());
                            Log.e("Refesh data: ","Finish");
                        }

                        @Override
                        public void onFailed(String message) {

                        }
                    });


        }
        else Log.e("Ticket: ","Not CheckIn");
    }

    private void clearRealmShowIng() {
        CurrentShowingManager.clearAllCurrentShowing(this);
        TicketManager.clearAllTicket(this);
        OrderManager.clearAllOrder(this);
        TicketTypeManager.clearAllTicketType(this);
    }

    private void checkInListTicket() {
        for(int i = 0;i< TicketManager.getListTicket(this).size();i++){
            TicketCheck ticketCheck = new TicketCheck();
            Ticket ticket = TicketManager.getListTicket(this).get(i);
            if(TicketManager.getListTicket(this).get(i).isChecked()==false){
                ticketCheck.setTicketId(ticket.getTicketId());
                ticketCheck.setTimeCheckIn(ticket.getCheckedInTime());
                listTicket.add(ticketCheck);
            }
        }
    }

    @Override
    public void onDestroy() {
        handler.removeCallbacks(runnable);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
