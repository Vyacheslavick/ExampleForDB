package com.example.slavick.examplefordb.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.slavick.examplefordb.Classes.Branch;
import com.example.slavick.examplefordb.R;

import java.util.List;

public class BranchAdapter extends RecyclerView.Adapter<BranchAdapter.ViewHolder> {

    public List<Branch> fullStrings;
    public BranchesItemClick branchesItemClick;
    public Context context;

    public BranchAdapter(List<Branch> fullStrings, BranchesItemClick branchesItemClick, Context context) {
        this.fullStrings = fullStrings;
        this.branchesItemClick = branchesItemClick;
        this.context = context;
    }

    public interface BranchesItemClick{
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
        Branch full = fullStrings.get(position);
        holder.fullString.setText(full.getFullName());
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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    branchesItemClick.onClick(getAdapterPosition());
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    branchesItemClick.onLongClick(getAdapterPosition());
                    return true;
                }
            });
        }
    }
}
