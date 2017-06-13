package com.example.mypc.retrofitexample.filter;

import android.widget.Filter;

import com.example.mypc.retrofitexample.adapter.RecyclerviewEventAdapter;
import com.example.mypc.retrofitexample.model.Events;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPC on 6/12/2017.
 */

public class CustomFilter extends Filter {
    private RecyclerviewEventAdapter adapter;
    private List<Events> filterList;
    public CustomFilter(List<Events> filterList, RecyclerviewEventAdapter adapter)
    {
        this.adapter=adapter;
        this.filterList=filterList;
    }
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results=new FilterResults();
        if(constraint != null && constraint.length() > 0)
        {
            constraint=constraint.toString().toUpperCase();
            ArrayList<Events> filteredPlayers=new ArrayList<>();
            for (int i=0;i<filterList.size();i++)
            {
                if(filterList.get(i).getEventName().toUpperCase().contains(constraint))
                {
                    filteredPlayers.add(filterList.get(i));
                }
            }
            results.count=filteredPlayers.size();
            results.values=filteredPlayers;
        }else
        {
            results.count=filterList.size();
            results.values=filterList;
        }
        return results;
    }
    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.contactInfoList= (ArrayList<Events>) results.values;
        adapter.notifyDataSetChanged();
    }
}
