package com.binay.taskproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.binay.taskproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajkiran on 12/03/17.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder> {
    List<String> stringArrayList;
    Context context;

    public RecyclerAdapter(Context taskOneActivity, ArrayList<String> stringArrayList) {
        this.stringArrayList = stringArrayList;
        this.context = taskOneActivity;
    }

    @Override
    public RecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_adapter_item, null);
        RecyclerAdapter.CustomViewHolder viewHolder = new RecyclerAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.textViewItem.setText("" + stringArrayList.get(position).toString());
    }


    @Override
    public int getItemCount() {
        return stringArrayList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView textViewItem;

        public CustomViewHolder(View itemView) {
            super(itemView);
            textViewItem = (TextView) itemView.findViewById(R.id.itemTextView);
        }
    }
}
