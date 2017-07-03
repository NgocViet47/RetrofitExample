package com.example.mypc.retrofitexample.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.actvity.ScannerBarcodeActivity;
import com.example.mypc.retrofitexample.actvity.ShowingActivity;
import com.example.mypc.retrofitexample.filter.CustomFilter;
import com.example.mypc.retrofitexample.model.Events;
import com.example.mypc.retrofitexample.putextra.BundleExtra;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by MyPC on 6/7/2017.
 */

public class RecyclerviewEventAdapter extends RecyclerView.Adapter<RecyclerviewEventAdapter.ViewHolder> implements Filterable {

    public List<Events> contactInfoList,filterList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private View itemView;
    private CustomFilter filter;

    public RecyclerviewEventAdapter(List<Events> contactInfoList, Context mContext) {
        this.mContext = mContext;
        this.contactInfoList = contactInfoList;
        filterList = contactInfoList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = mLayoutInflater.inflate(R.layout.item_event, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvTitle.setText(contactInfoList.get(position).getVenueTitle());
        holder.tvAddress.setText(contactInfoList.get(position).getVenueFullAddress());
        holder.tvType.setText(contactInfoList.get(position).getEventName());
        Picasso.with(mContext)
                .load(contactInfoList.get(position).getEventCoverImageUrl())
                .placeholder(R.color.colorPrimary)
                .fit()
                .centerInside()
                .noFade()
                .tag(mContext)
                .into(holder.imgEvent);
    }

    @Override
    public int getItemCount() {
        return (contactInfoList!=null)?contactInfoList.size():0;
    }

    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new CustomFilter(filterList,this);
        }
        return filter;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        protected TextView tvTitle,tvType,tvAddress;
        protected ImageView imgEvent;
        protected LinearLayout loButtonSumaryEvent,loButtonCheckIn;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitleItemEvent);
            tvType = (TextView) itemView.findViewById(R.id.tvTypeItemEvent);
            tvAddress = (TextView) itemView.findViewById(R.id.tvAddressItemEvent);
            imgEvent = (ImageView) itemView.findViewById(R.id.imgCenterItemEvent);
            loButtonSumaryEvent = (LinearLayout) itemView.findViewById(R.id.loButtonSumaryItemEvent);
            loButtonCheckIn = (LinearLayout) itemView.findViewById(R.id.loButtonCheckInItemEvent);

            loButtonSumaryEvent.setOnClickListener(this);
            loButtonCheckIn.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.loButtonSumaryItemEvent:
                    loButtonSumaryEventButton();
                    break;
                case R.id.loButtonCheckInItemEvent:
                    loButtonCheckInButton();
                    break;
            }
        }

        private void loButtonCheckInButton() {
            Intent intent =new Intent(mContext, ScannerBarcodeActivity.class);
            mContext.startActivity(intent);
        }

        private void loButtonSumaryEventButton() {
            Intent intent = new Intent(mContext, ShowingActivity.class);
            /*String dateIntent = GeneralMethods.getGson().toJson(contactInfoList.get(getAdapterPosition()).getShowings());
            intent.putExtra(BundleExtra.PUT_SHOWING,dateIntent);*/
            intent.putExtra(BundleExtra.PUT_EVENTID,contactInfoList.get(getAdapterPosition()).getEventId());
            mContext.startActivity(intent);
        }
    }


}
