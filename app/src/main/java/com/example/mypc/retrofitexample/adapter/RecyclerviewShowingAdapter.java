package com.example.mypc.retrofitexample.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.actvity.SumaryActivity;
import com.example.mypc.retrofitexample.model.ShowingEvent;
import com.example.mypc.retrofitexample.utils.TimeManager;
import com.example.mypc.retrofitexample.putextra.BundleExtra;
import com.example.mypc.retrofitexample.retrofit.GeneralMethods;

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

    public RecyclerviewShowingAdapter(List<ShowingEvent> contactInfoList, Context mContext) {
        this.contactInfoList = contactInfoList;
        this.mContext = mContext;
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
        holder.tvMonthAndYear.setText(TimeManager.getCalendar(dateTime).getDisplayName(Calendar.MONTH,Calendar.LONG, Locale.ENGLISH)+" "+ TimeManager.getCalendar(dateTime).get(Calendar.YEAR));
        holder.tvDay.setText(TimeManager.getNameDateFromCalendar(dateTime));
        holder.tvDate.setText(TimeManager.getCalendar(dateTime).get(Calendar.DATE)+"");
        holder.tvTime.setText(TimeManager.getTimeByhhmmaa(dateTime));
    }

    @Override
    public int getItemCount() {
        return (contactInfoList != null) ? contactInfoList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView tvMonthAndYear, tvDate, tvDay,tvTime;
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
            switch (v.getId()){
                case R.id.loButtonTimeShowing:
                    loButtonTimeButton();
                    break;
            }
        }

        private void loButtonTimeButton() {
            Intent intent = new Intent(mContext, SumaryActivity.class);
            String dataShowing = GeneralMethods.getGson().toJson(contactInfoList.get(getAdapterPosition()));
            intent.putExtra(BundleExtra.PUT_SHOWING,dataShowing);
            mContext.startActivity(intent);
        }
    }
}
