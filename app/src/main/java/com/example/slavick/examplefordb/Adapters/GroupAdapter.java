package com.example.slavick.examplefordb.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.slavick.examplefordb.Classes.Group;
import com.example.slavick.examplefordb.R;

import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder>{

    public Context context;
    public List<Group> groupList;
    public GroupItemClick groupItemClick;

    public GroupAdapter(Context context, List<Group> groupList, GroupItemClick groupItemClick) {
        this.context = context;
        this.groupList = groupList;
        this.groupItemClick = groupItemClick;
    }

    public interface GroupItemClick{
        void onClick(int position);
        void onLongClick(int position);
    }

    @NonNull
    @Override
    public GroupAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(context).inflate(R.layout.group_item,parent,false);
        return new ViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupAdapter.ViewHolder holder, int position) {
        Group group = groupList.get(position);
        holder.group.setText(group.getShortName());
    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView group;
        public ViewHolder(View itemView) {
            super(itemView);
            group = itemView.findViewById(R.id.group);
        }
    }
}
