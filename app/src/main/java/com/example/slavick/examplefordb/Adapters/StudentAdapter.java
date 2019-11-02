package com.example.slavick.examplefordb.Adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.slavick.examplefordb.Classes.Student;
import com.example.slavick.examplefordb.R;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder>{

    public Context context;
    public List<Student> students;
    public StudentItemClick recycleItemClick;

    public StudentAdapter(Context context, List<Student> students, StudentItemClick recycleItemClick) {
        this.context = context;
        this.students = students;
        this.recycleItemClick = recycleItemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(context).inflate(R.layout.student_item,parent,false);
        return new ViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = students.get(position);
        String s = Integer.toString(position+1).concat(".");
        holder.index.setText(s);
        s = student.getSername() + " " + String.valueOf(student.getName().charAt(0)) + ". " + String.valueOf(student.getFathers().charAt(0)) + ".";
        holder.name.setText(s);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public interface StudentItemClick{
        void onClick(int position);
        void onLongClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView index;
        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            index = itemView.findViewById(R.id.index);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recycleItemClick.onClick(getAdapterPosition());
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    recycleItemClick.onLongClick(getAdapterPosition());
                    return true;
                }
            });
        }
    }
}
