package com.example.slavick.examplefordb.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.slavick.examplefordb.R;

import java.util.List;

public class ThingsAdapter extends RecyclerView.Adapter<ThingsAdapter.ViewHolder> {

    List<String> fullStrings;
    ThingsItemClick thingsItemClick;
    Context context;

    public ThingsAdapter(List<String> fullStrings, ThingsItemClick thingsItemClick, Context context) {
        this.fullStrings = fullStrings;
        this.thingsItemClick = thingsItemClick;
        this.context = context;
    }

    public interface ThingsItemClick{
        void onClick(int position);
        void onLongClick(int position);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(context).inflate(R.layout.group_item,parent,false);
        return new ViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String full = fullStrings.get(position);
        holder.fullString.setText(full);
    }

    @Override
    public int getItemCount() {
        return fullStrings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView fullString;
        public ViewHolder(View itemView) {
            super(itemView);
            fullString = itemView.findViewById(R.id.group);
        }
    }
}
