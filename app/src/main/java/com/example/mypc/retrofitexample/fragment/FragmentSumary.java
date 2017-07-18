package com.example.mypc.retrofitexample.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.actvity.TicketSoldActivity;
import com.example.mypc.retrofitexample.circleprogress.DonutProgress;
import com.example.mypc.retrofitexample.constant.ConstantCheckIn;
import com.example.mypc.retrofitexample.model.responseResultModel.ResultResponse;
import com.example.mypc.retrofitexample.model.ShowingEvent;
import com.example.mypc.retrofitexample.model.Ticket;
import com.example.mypc.retrofitexample.model.TicketSale;
import com.example.mypc.retrofitexample.model.TicketSaleByDate;
import com.example.mypc.retrofitexample.utils.TimeManager;
import com.example.mypc.retrofitexample.model.responseResultModel.ResponseOrderShowInData;
import com.example.mypc.retrofitexample.model.responseResultModel.ResponseReportData;
import com.example.mypc.retrofitexample.putextra.BundleExtra;
import com.example.mypc.retrofitexample.repository.CallBackData;
import com.example.mypc.retrofitexample.repository.RepositoryService;
import com.example.mypc.retrofitexample.repository.TicketboxRepository;
import com.example.mypc.retrofitexample.retrofit.GeneralMethods;
import com.example.mypc.retrofitexample.sharedpreference.SharedPreference;
import com.google.gson.reflect.TypeToken;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by MyPC on 6/20/2017.
 */

public class FragmentSumary extends Fragment implements View.OnClickListener {

    private ResponseReportData reportData;
    private TextView tvTotalCommissions
            ,tvNameEventShowing
            ,tvTimeStartShowingEvent
            ,tvTimeStartShowing
            ,tvTimeEndShowing
            ,tvTotalIncome
            ,tvTotalSales
            ,tvTotalExtraCharge
            ,tvTotalServiceFee
            ,tvTotalTicketSold
            ,tvTicketPaid
            ,tvTicketCancel
            ,tvTicketProcess
            ,tvToltalTicketCheckIn
            ,tvTypeTicketCheckin
            ,tvNumberTicketIsCheckIn
            ,tvLastSyncTime;
    private DonutProgress progressTotalTicketSold;
    private LinearLayout loButtonStartDate,loButtonEndDate,loPercentTicketSold,loTicketCheckIn;
    private Button btnSeeMoreSummary;
    private Calendar dateTime;
    private CircleImageView imgColorTicketCheckIn;

    private int loadDialog;

    private ShowingEvent showingEvent;
    private ResponseOrderShowInData responseOrderShowInData;
    private List<TicketSale> listTicketSale = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summary, container, false);
        getReportForShowing();
        initialView(view);
        addEvent();
        return view;
    }

    private void setTvTicketCheckIn(){

        final TicketboxRepository repository = new RepositoryService();
        repository.getShowInOrder(getContext()
                , showingEvent.getShowingId()
                , SharedPreference.getString(SharedPreference.KEY_TIME_ZONE,getContext())
                , new CallBackData<ResultResponse<ResponseOrderShowInData>>() {
                    @Override
                    public void onResponseData(ResultResponse<ResponseOrderShowInData> responseOrderShowInDataResultResponse) {
                        responseOrderShowInData = responseOrderShowInDataResultResponse.getData();
                        String time = responseOrderShowInData.getLastSyncTime();
                        tvLastSyncTime.setText(TimeManager.getLastSyncTimeByISO8601(time));

                        List<Ticket> ticketList = responseOrderShowInData.getCurrentShowing().getTickets();
                        List<TicketSaleByDate> ticketSaleByDates = reportData.getTicketSaleByDates();
                        int totalTicketCheckIn = 0;
                        for (int i = 0; i < listTicketSale.size(); i++) {
                            TicketSale ticketSale = listTicketSale.get(i);
                            int number = 0;
                            for (int j = 0; j < ticketList.size(); j++) {
                                if (listTicketSale.get(i).getTicketTypeId().equals(ticketList.get(j).getTicketTypeId())) {
                                    if (ticketList.get(j).getStatus().equals(ConstantCheckIn.CHECK_IN)) {

                                    } else
                                        number++;
                                }
                            }
                            totalTicketCheckIn+=number;

                            View viewTicketCheckIn = LayoutInflater.from(getContext()).inflate(R.layout.item_ticket_checkin,null);
                            loTicketCheckIn.addView(viewTicketCheckIn);

                            tvTypeTicketCheckin = (TextView) viewTicketCheckIn.findViewById(R.id.tvTypeTicketCheckIn);
                            tvNumberTicketIsCheckIn = (TextView) viewTicketCheckIn.findViewById(R.id.tvNumberTicketCheckIn);
                            imgColorTicketCheckIn = (CircleImageView) viewTicketCheckIn.findViewById(R.id.imgColorTicketCheckIn);

                            tvTypeTicketCheckin.setText(ticketSale.getTicketTypeName());
                            tvNumberTicketIsCheckIn.setText(number+"");

                            String color = "#"+ticketSaleByDates.get(i).getColor();
                            imgColorTicketCheckIn.setBorderColor(Color.parseColor(color));
                            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor(color));
                            Picasso.with(getContext()).load(Color.parseColor(color))
                                    .placeholder(colorDrawable)
                                    .fit()
                                    .centerInside()
                                    .noFade()
                                    .tag(this)
                                    .into(imgColorTicketCheckIn);

                        }
                        tvToltalTicketCheckIn.setText(totalTicketCheckIn+" Ticket(S)");
                    }

                    @Override
                    public void onFailed(String message) {

                    }
                });
    }

    private void setLOViewPercentTicketSold() {
        listTicketSale = reportData.getTicketSales();
        List<TicketSaleByDate> listTicketByDate = reportData.getTicketSaleByDates();
        for(int i=0;i<listTicketSale.size();i++) {

            TicketSale ticketSale = listTicketSale.get(i);
            View viewPercentTicketSold = LayoutInflater.from(getContext()).inflate(R.layout.item_percent_ticket_sold, null);

            loPercentTicketSold.addView(viewPercentTicketSold);

            DonutProgress progressTicketSold = (DonutProgress) viewPercentTicketSold.findViewById(R.id.donut_progress_percent_ticket);
            progressTicketSold.setColorProgess(Color.parseColor("#"+listTicketByDate.get(i).getColor()));

            TextView tvTicketSoldForQuantity = (TextView) viewPercentTicketSold.findViewById(R.id.tvTicketSoldForQuantity);
            TextView tvTicketType = (TextView) viewPercentTicketSold.findViewById(R.id.tvTicketType);

            tvTicketSoldForQuantity.setText(ticketSale.getPaidQuantity()+"/"+ticketSale.getQuantity());
            tvTicketType.setText(ticketSale.getTicketTypeName());

            progressTicketSold.setProgress(getPercentForValueInteger(ticketSale.getPaidQuantity(),ticketSale.getQuantity()));
        }

    }

    private void addEvent() {
        loButtonStartDate.setOnClickListener(this);
        loButtonEndDate.setOnClickListener(this);
        btnSeeMoreSummary.setOnClickListener(this);
    }

    private void initialView(View view) {
        tvTotalCommissions = (TextView) view.findViewById(R.id.tvTotalCommissions);
        tvNameEventShowing = (TextView) view.findViewById(R.id.tvNameEventShowing);
        tvTimeStartShowingEvent = (TextView) view.findViewById(R.id.tvTimeStartEvent);
        tvTimeStartShowing = (TextView) view.findViewById(R.id.tvStartTimeShowing);
        tvTimeEndShowing = (TextView) view.findViewById(R.id.tvEndTimeShowing);
        tvTotalSales = (TextView) view.findViewById(R.id.tvTotalSales);
        tvTotalExtraCharge = (TextView) view.findViewById(R.id.tvTotalExtraCharge);
        tvTotalServiceFee = (TextView) view.findViewById(R.id.tvTotalServiceFee);
        tvTotalIncome = (TextView) view.findViewById(R.id.tvTotalIncome);
        tvTotalTicketSold = (TextView) view.findViewById(R.id.tvTotalTicketSold);
        tvTicketPaid = (TextView) view.findViewById(R.id.tvTicketPaid);
        tvTicketCancel = (TextView) view.findViewById(R.id.tvTicketCancel);
        tvTicketProcess = (TextView) view.findViewById(R.id.tvTicketProcessing);
        tvToltalTicketCheckIn = (TextView) view.findViewById(R.id.tvTotalTicketIsCheckIn);
        tvLastSyncTime = (TextView) view.findViewById(R.id.tvLastSyncTimeSummary);

        loButtonStartDate = (LinearLayout) view.findViewById(R.id.loButtonStartDateCalendar);
        loButtonEndDate = (LinearLayout) view.findViewById(R.id.loButtonEndDateCalendar);
        loPercentTicketSold = (LinearLayout) view.findViewById(R.id.loViewPercentTicketSold);
        loTicketCheckIn = (LinearLayout) view.findViewById(R.id.loTicketIsCheckIn);

        btnSeeMoreSummary = (Button) view.findViewById(R.id.btnSeeMoreSummary);

        progressTotalTicketSold = (DonutProgress) view.findViewById(R.id.progressTotalTicketSold);
        progressTotalTicketSold.setColorProgess(Color.rgb(102, 153, 0));
    }

    public void getReportForShowing() {
        Bundle bundle = getActivity().getIntent().getExtras();
        String dataShowing = bundle.getString(BundleExtra.PUT_SHOWING);
        Type type = new TypeToken<ShowingEvent>() {
        }.getType();
        showingEvent = GeneralMethods.getGson().fromJson(dataShowing, type);
        TicketboxRepository repository = new RepositoryService();
        repository.getRePorting(getContext()
                , showingEvent.getEventId()
                , showingEvent.getShowingId()
                , showingEvent.getShowingStartDate()
                , showingEvent.getShowingEndDate()
                , SharedPreference.getString(SharedPreference.KEY_TIME_ZONE, getContext())
                , new CallBackData<ResultResponse<ResponseReportData>>() {
                    @Override
                    public void onResponseData(ResultResponse<ResponseReportData> responseReportDataResultResponse) {
                        reportData = responseReportDataResultResponse.getData();
                        loadTextView();
                        setLOViewPercentTicketSold();
                        setTvTicketCheckIn();
                    }

                    @Override
                    public void onFailed(String message) {
                        Log.e("Failed", "Failed");
                    }
                });
    }

    private void loadTextView() {

        DecimalFormat formatNumber = new DecimalFormat("###,###,###,###");
        String currency = reportData.getCurrency();

        tvTotalCommissions.setText(reportData.getTkbRate());
        tvTotalExtraCharge.setText(String.valueOf(reportData.getExtraChargeAmount()));
        tvTotalServiceFee.setText(formatNumber.format(reportData.getServiceFee())+" "+currency);
        tvTotalExtraCharge.setText(formatNumber.format(reportData.getExtraChargeAmount()) +" "+currency);
        tvNameEventShowing.setText(reportData.getEventName());
        tvTimeStartShowingEvent.setText(TimeManager.getDayMothYear(reportData.getStartDate())+" - "+TimeManager.getTimeByhhmmaa(reportData.getStartDate()));
        tvTimeStartShowing.setText(TimeManager.getDayMothYear(reportData.getStartDate()));
        tvTimeEndShowing.setText(TimeManager.getDayMothYear(reportData.getEndDate()));
        tvTotalSales.setText(formatNumber.format(reportData.getRevenue())+ " "+currency);
        tvTotalIncome.setText(formatNumber.format(reportData.getRevenue() - reportData.getServiceFee()) + " " +currency);

        tvTotalTicketSold.setText(reportData.getTotalPaidTicketQuantity()+"/"+reportData.getTotalTicketQuantity());
        tvTicketPaid.setText(reportData.getTotalPaidTicketQuantity()+" Ticket(S)");
        tvTicketCancel.setText(reportData.getTotalCanceledTicketQuantity()+" Ticket(S)");
        tvTicketProcess.setText(reportData.getTotalProcessingTicketQuantity()+" Ticket(S)");


        progressTotalTicketSold.setProgress(getPercentForValueInteger(reportData.getTotalPaidTicketQuantity(),reportData.getTotalTicketQuantity()));


    }

    private int getPercentForValueInteger(Integer totalPaidTicketQuantity, Integer totalTicketQuantity) {
       int percent = (int) ((Float.valueOf(totalPaidTicketQuantity)
                       /Float.valueOf(totalTicketQuantity))
                       *100);
        return percent;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loButtonStartDateCalendar:
                loButtonStartDateButton();
                break;
            case R.id.loButtonEndDateCalendar:
                loButtonEndDateButton();
                break;
            case R.id.btnSeeMoreSummary:
                btnSeeMoreSummaryButton();
                break;
        }
    }

    private void btnSeeMoreSummaryButton() {
        Intent intent = new Intent(getContext(), TicketSoldActivity.class);
        String reportDataSend = GeneralMethods.getGson().toJson(reportData);
        intent.putExtra(BundleExtra.PUT_REPORT,reportDataSend);
        startActivity(intent);
    }

    private void loButtonEndDateButton() {
        loadDialog = 1;
        loadDialog();
    }

    private void loadDialog() {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
        View mView = getActivity().getLayoutInflater().inflate(R.layout.dialog_calendar,null);
        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();

        MaterialCalendarView cal = (MaterialCalendarView) mView.findViewById(R.id.calendarView);
        dialog.show();
        /*if(loadDialog==0){
            dateTime=TimeManager.getCalendar(reportData.getStartDate());
            cal.setDateSelected(dateTime,true);
        }else
        {
            dateTime=TimeManager.getCalendar(reportData.getEndDate());
            cal.setDateSelected(dateTime,true);
        }*/
        dateTime = Calendar.getInstance();
        cal.setDateSelected(dateTime,true);
        cal.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                dateTime = date.getCalendar();
                if(loadDialog == 0){
                    tvTimeStartShowing.setText(TimeManager.getDayMothYearByCalendar(dateTime));
                }else {
                    tvTimeEndShowing.setText(TimeManager.getDayMothYearByCalendar(dateTime));
                }
                dialog.dismiss();
            }
        });
    }

    private void loButtonStartDateButton() {
        loadDialog = 0;
        loadDialog();

    }
}

