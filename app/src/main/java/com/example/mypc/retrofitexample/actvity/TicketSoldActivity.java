package com.example.mypc.retrofitexample.actvity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.model.TicketPaidSummary;
import com.example.mypc.retrofitexample.model.TicketProccessingSummary;
import com.example.mypc.retrofitexample.model.responseResultModel.ResponseReportData;
import com.example.mypc.retrofitexample.putextra.BundleExtra;
import com.example.mypc.retrofitexample.retrofit.GeneralMethods;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class TicketSoldActivity extends BaseActivity {

    private ResponseReportData reportData;
    private TextView tvPaidTicket, tvPaidOfficePickUp, tvPaidBankTransfer, tvPaidCashAtPayment, tvPaidOnlinePayment, tvProcessNewBooking, tvProcessTicket, tvProcessOndelivery, tvProcessOfficePickUp, tvProcessBankTransfer, tvProcessCashAtPayment, tvProcessOnlinePayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_sold);
        inittialView();
        loadTextview();
    }

    private void loadTextview() {
        TicketPaidSummary ticketPaidSummary = reportData.getTicketPaidSummary();
        TicketProccessingSummary ticketProccessingSummary = reportData.getTicketProccessingSummary();

        tvPaidTicket.setText(reportData.getTotalPaidTicketQuantity()+" Ticket(S)");
        tvPaidOnlinePayment.setText(ticketPaidSummary.getOpCount()+"");
        tvPaidBankTransfer.setText(ticketPaidSummary.getBankTransferCount()+"");
        tvPaidCashAtPayment.setText(ticketPaidSummary.getCodCount()+"");
        tvPaidOfficePickUp.setText(ticketPaidSummary.getPayooCount()+"");

        tvProcessTicket.setText(reportData.getTotalProcessingTicketQuantity()+" Ticket(S)");
        tvProcessOfficePickUp.setText(ticketProccessingSummary.getWaitingForPayment().getOfficePickup()+"");
        tvProcessBankTransfer.setText(ticketProccessingSummary.getWaitingForPayment().getBankTransfer()+"");
        tvProcessOnlinePayment.setText(ticketProccessingSummary.getWaitingForPayment().getConvenientStore()+"");
        tvProcessCashAtPayment.setText(ticketProccessingSummary.getWaitingForPayment().getOther()+"");
        tvProcessNewBooking.setText(ticketProccessingSummary.getCashOnDelivery().getNewOrder()+"");
        tvProcessOndelivery.setText(ticketProccessingSummary.getCashOnDelivery().getDelivering()+"");
    }

    private void inittialView() {
        Bundle bundle = getIntent().getExtras();
        String dataReport = bundle.getString(BundleExtra.PUT_REPORT);
        Type type = new TypeToken<ResponseReportData>() {
        }.getType();
        reportData = GeneralMethods.getGson().fromJson(dataReport, type);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        tvPaidTicket = (TextView) findViewById(R.id.tvTicketPaidSold);
        tvPaidBankTransfer = (TextView) findViewById(R.id.tvPaidBankTransfer);
        tvPaidCashAtPayment = (TextView) findViewById(R.id.tvPaidCashAtPayment);
        tvPaidOfficePickUp = (TextView) findViewById(R.id.tvPaidOffice);
        tvPaidOnlinePayment = (TextView) findViewById(R.id.tvPaidOnlinePayment);
        tvProcessTicket = (TextView) findViewById(R.id.tvProcessTicket);
        tvProcessOndelivery = (TextView) findViewById(R.id.tvOnDeliveryProcess);
        tvProcessOfficePickUp = (TextView) findViewById(R.id.tvOfficePickUpProcess);
        tvProcessBankTransfer = (TextView) findViewById(R.id.tvBankTransferProcess);
        tvProcessOnlinePayment = (TextView) findViewById(R.id.tvProcessOnlinePayment);
        tvProcessCashAtPayment = (TextView) findViewById(R.id.tvCashAtPaymentProcess);
        tvProcessNewBooking = (TextView) findViewById(R.id.tvNewBooking);
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
