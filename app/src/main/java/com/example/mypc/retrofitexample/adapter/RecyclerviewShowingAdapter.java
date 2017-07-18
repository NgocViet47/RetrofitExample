package com.example.mypc.retrofitexample.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.actvity.ScannerBarcodeActivity;
import com.example.mypc.retrofitexample.actvity.SumaryActivity;
import com.example.mypc.retrofitexample.constant.ConstantStatusShowIn;
import com.example.mypc.retrofitexample.model.ShowingEvent;
import com.example.mypc.retrofitexample.model.responseResultModel.ResponseOrderShowInData;
import com.example.mypc.retrofitexample.model.responseResultModel.ResultResponse;
import com.example.mypc.retrofitexample.putextra.BundleExtra;
import com.example.mypc.retrofitexample.repository.CallBackData;
import com.example.mypc.retrofitexample.repository.RepositoryService;
import com.example.mypc.retrofitexample.repository.TicketboxRepository;
import com.example.mypc.retrofitexample.retrofit.GeneralMethods;
import com.example.mypc.retrofitexample.service.ServiceUpdateTicket;
import com.example.mypc.retrofitexample.sharedpreference.SharedPreference;
import com.example.mypc.retrofitexample.utils.CurrentShowingManager;
import com.example.mypc.retrofitexample.utils.OrderManager;
import com.example.mypc.retrofitexample.utils.TicketManager;
import com.example.mypc.retrofitexample.utils.TicketTypeManager;
import com.example.mypc.retrofitexample.utils.TimeManager;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by MyPC on 6/13/2017.
 */

public class RecyclerviewShowingAdapter extends RecyclerView.Adapter<RecyclerviewShowingAdapter.ViewHolder> {

    private List<ShowingEvent> contactInfoList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private View itemView;
    private String isStatusShowIn;

    private Intent myIntent = null;

    public RecyclerviewShowingAdapter(List<ShowingEvent> contactInfoList, String isStatusShowIn, Context mContext) {
        this.contactInfoList = contactInfoList;
        this.mContext = mContext;
        this.isStatusShowIn = isStatusShowIn;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = mLayoutInflater.inflate(R.layout.item_showing, parent, false);
        return new RecyclerviewShowingAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String dateTime = contactInfoList.get(position).getShowingStartDate();
        holder.tvMonthAndYear.setText(TimeManager.getCalendar(dateTime).getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH) + " " + TimeManager.getCalendar(dateTime).get(Calendar.YEAR));
        holder.tvDay.setText(TimeManager.getNameDateFromCalendar(dateTime));
        holder.tvDate.setText(TimeManager.getCalendar(dateTime).get(Calendar.DATE) + "");
        holder.tvTime.setText(TimeManager.getTimeByhhmmaa(dateTime));
    }

    @Override
    public int getItemCount() {
        return (contactInfoList != null) ? contactInfoList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView tvMonthAndYear, tvDate, tvDay, tvTime;
        protected LinearLayout loButtonTime;

        public ViewHolder(View itemView) {
            super(itemView);
            tvMonthAndYear = (TextView) itemView.findViewById(R.id.tvMonthAndYearShowing);
            tvDate = (TextView) itemView.findViewById(R.id.tvDateShowing);
            tvDay = (TextView) itemView.findViewById(R.id.tvDayShowing);
            tvTime = (TextView) itemView.findViewById(R.id.tvTimeShowing);
            loButtonTime = (LinearLayout) itemView.findViewById(R.id.loButtonTimeShowing);
            loButtonTime.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.loButtonTimeShowing:
                    loButtonTimeButton();
                    break;
            }
        }

        private void loButtonTimeButton() {
            if (isStatusShowIn.equals(ConstantStatusShowIn.IS_SUMMARY)) {
                Intent intent = new Intent(mContext, SumaryActivity.class);
                String dataShowing = GeneralMethods.getGson().toJson(contactInfoList.get(getAdapterPosition()));
                intent.putExtra(BundleExtra.PUT_SHOWING, dataShowing);
                intent.putExtra(BundleExtra.PUT_SHOW_IN_ID, contactInfoList.get(getAdapterPosition()).getShowingId());
                saveTicketRealmByShowInId();
                mContext.startActivity(intent);
            } else {
                Intent intent = new Intent(mContext, ScannerBarcodeActivity.class);
                intent.putExtra(BundleExtra.PUT_SHOW_IN_ID, contactInfoList.get(getAdapterPosition()).getShowingId());
                saveTicketRealmByShowInId();
                mContext.startActivity(intent);
            }
        }

        private void saveTicketRealmByShowInId() {
            //TODO set item again not delete
            if (CurrentShowingManager.getListCurrentShowing(mContext) != null
                    ||TicketManager.getListTicket(mContext).size()!=0) {
                CurrentShowingManager.clearAllCurrentShowing(mContext);
                TicketManager.clearAllTicket(mContext);
                OrderManager.clearAllOrder(mContext);
                TicketTypeManager.clearAllTicketType(mContext);
            }
            TicketboxRepository repository = new RepositoryService();
            repository.getShowInOrder(mContext, contactInfoList.get(getAdapterPosition()).getShowingId(), SharedPreference.getString(SharedPreference.KEY_TIME_ZONE, mContext), new CallBackData<ResultResponse<ResponseOrderShowInData>>() {
                @Override
                public void onResponseData(ResultResponse<ResponseOrderShowInData> responseOrderShowInDataResultResponse) {
                    CurrentShowingManager.createCurrentShowing(mContext, responseOrderShowInDataResultResponse.getData().getCurrentShowing());
                }

                @Override
                public void onFailed(String message) {

                }
            });
            startServiceUpdateTicket();
        }

        private void startServiceUpdateTicket() {
            Intent myIntent = new Intent(mContext, ServiceUpdateTicket.class);
            Log.e("Stop","Stop");
            mContext.startService(myIntent);
        }
    }
}
