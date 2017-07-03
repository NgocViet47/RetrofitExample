package com.example.mypc.retrofitexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.model.Order;
import com.example.mypc.retrofitexample.model.OrderAndNumberTicket;

import java.util.List;

/**
 * Created by MyPC on 6/27/2017.
 */

public class RecyclerviewOrderAdapter extends RecyclerView.Adapter<RecyclerviewOrderAdapter.ViewHolder> {

    private List<OrderAndNumberTicket> orderList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private View itemView;
    public RecyclerviewOrderAdapter(List<OrderAndNumberTicket>orderList, Context context){
        this.orderList = orderList;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = mLayoutInflater.inflate(R.layout.item_order_list, parent, false);
        return new RecyclerviewOrderAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        OrderAndNumberTicket orderAndNumberTicket = orderList.get(position);
        Order order = orderAndNumberTicket.getOrder();

        holder.tvName.setText(order.getBuyerFirstName() + order.getBuyerLastName());
        holder.tvEmail.setText(order.getBuyerEmail());
        holder.tvPhoneNumber.setText(order.getBuyerPhoneNumber());
        holder.tvTotalTicketOrder.setText(orderAndNumberTicket.getNumberTicket()+"");
    }

    @Override
    public int getItemCount() {
        return (orderList !=null)? orderList.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        protected TextView tvTotalTicketOrder,tvName,tvEmail,tvPhoneNumber;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvNameOrder);
            tvEmail = (TextView) itemView.findViewById(R.id.tvEmailOrder);
            tvPhoneNumber = (TextView) itemView.findViewById(R.id.tvPhoneNumberOrder);
            tvTotalTicketOrder = (TextView) itemView.findViewById(R.id.tvNumberTicketOrder);
        }

    }
}
