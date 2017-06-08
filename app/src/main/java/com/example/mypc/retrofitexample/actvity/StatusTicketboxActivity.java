package com.example.mypc.retrofitexample.actvity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.model.ResultResponse;
import com.example.mypc.retrofitexample.model.responseResultModel.ResponseEventData;
import com.example.mypc.retrofitexample.repository.CallBackData;
import com.example.mypc.retrofitexample.repository.RepositoryService;
import com.example.mypc.retrofitexample.repository.TicketboxRepository;
import com.example.mypc.retrofitexample.sharedpreference.SharedPreference;

import java.util.List;

public class StatusTicketboxActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnGetListTicketBox, btnGetListOrder, btngetEvents;
    private TextView tvGetStatusTicKetBox;
    private static final String DATA_NAME_SHAREDPREFERENCES = "myDataSharedPreferences";
    private static final String KEY_LAST_SYNC_TIME = "lastSyncTime";
    private String lastSyncTime = "";
    private String timeZone = "+07:00";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_ticketbox);

        initialView();
        addEvent();
        SharedPreference.saveString(lastSyncTime,SharedPreference.KEY_LAST_SYNC_TIME,this);
    }

    private void addEvent() {
        btnGetListTicketBox.setOnClickListener(this);
        btnGetListOrder.setOnClickListener(this);
        btngetEvents.setOnClickListener(this);
    }

    private void initialView() {
        btnGetListTicketBox = (Button) findViewById(R.id.btnGetListStatusTicketBox);
        btnGetListOrder = (Button) findViewById(R.id.btnGetListStatusOrder);
        tvGetStatusTicKetBox = (TextView) findViewById(R.id.tvGetDataTicketBox);
        btngetEvents = (Button) findViewById(R.id.btnGetEvent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGetListStatusTicketBox:
                btnGetListTicketBoxButton();
                break;
            case R.id.btnGetListStatusOrder:
                btnGetListOrderButton();
                break;
            case R.id.btnGetEvent:
                btngetEventsButton();
                break;
        }
    }

    private void btngetEventsButton() {
        TicketboxRepository repository = new RepositoryService();
        repository.getEvents(this, timeZone,SharedPreference.getString(SharedPreference.KEY_LAST_SYNC_TIME,this), new CallBackData<ResultResponse<ResponseEventData>>() {
            @Override
            public void onResponseData(ResultResponse<ResponseEventData> dataResultResponse) {
                lastSyncTime = dataResultResponse.getData().getLastSyncTime();
                SharedPreference.saveString(lastSyncTime,SharedPreference.KEY_LAST_SYNC_TIME,getApplicationContext());
                String listTitleEvents="";
                if(dataResultResponse.getData().getEvents()!=null){
                    for (int i = 0;i<dataResultResponse.getData().getEvents().size();i++){
                        listTitleEvents += "\n"+dataResultResponse.getData().getEvents().get(i).getVenueTitle();
                    }
                    tvGetStatusTicKetBox.setText(listTitleEvents);
                }

            }

            @Override
            public void onFailed(String message) {

            }
        });
    }

    private void btnGetListOrderButton() {
        TicketboxRepository repository = new RepositoryService();
        repository.getStatusOrder(this, new CallBackData<ResultResponse<List<Integer>>>() {
            @Override
            public void onResponseData(ResultResponse<List<Integer>> listResultResponse) {
                String getData = "";
                for (int i : listResultResponse.getData()) {
                    getData += "\n" + i;
                }
                tvGetStatusTicKetBox.setText(getData);
            }

            @Override
            public void onFailed(String message) {
                tvGetStatusTicKetBox.setText("Error");
            }
        });
    }

    private void btnGetListTicketBoxButton() {
        TicketboxRepository repository = new RepositoryService();
        repository.getStatusTicketBox(this, new CallBackData<ResultResponse<List<Integer>>>() {
            @Override
            public void onResponseData(ResultResponse<List<Integer>> listResultResponse) {
                String getData = "";
                for (int i : listResultResponse.getData()) {
                    getData += "\n" + i;
                }
                tvGetStatusTicKetBox.setText(getData);
            }

            @Override
            public void onFailed(String message) {

            }
        });
    }
}
