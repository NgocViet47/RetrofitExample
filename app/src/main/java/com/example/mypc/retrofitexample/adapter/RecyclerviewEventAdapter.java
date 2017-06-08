package com.example.mypc.retrofitexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.model.Events;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by MyPC on 6/7/2017.
 */

public class RecyclerviewEventAdapter extends RecyclerView.Adapter<RecyclerviewEventAdapter.ViewHolder> {

    private List<Events> contactInfoList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private View itemView;

    public RecyclerviewEventAdapter(List<Events> contactInfoList, Context mContext) {
        this.mContext = mContext;
        this.contactInfoList = contactInfoList;
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

    public class ViewHolder extends RecyclerView.ViewHolder{

        protected TextView tvTitle,tvType,tvAddress;
        protected ImageView imgEvent;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitleItemEvent);
            tvType = (TextView) itemView.findViewById(R.id.tvTypeItemEvent);
            tvAddress = (TextView) itemView.findViewById(R.id.tvAddressItemEvent);
            imgEvent = (ImageView) itemView.findViewById(R.id.imgCenterItemEvent);
        }
    }
}
