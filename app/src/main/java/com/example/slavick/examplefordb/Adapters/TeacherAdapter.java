package com.example.slavick.examplefordb.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.slavick.examplefordb.Classes.Semester;
import com.example.slavick.examplefordb.Classes.Teacher;
import com.example.slavick.examplefordb.R;
import com.example.slavick.examplefordb.SupportFeatures.App;

import java.util.ArrayList;
import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.ViewHolder> {

    public Context context;
    public List<Teacher> teachers;
    public TeacherItemClick teacherItemClick;

    public TeacherAdapter(Context context, List<Teacher> teachers, TeacherItemClick teacherItemClick) {
        this.context = context;
        this.teachers = teachers;
        this.teacherItemClick = teacherItemClick;
    }

    public interface TeacherItemClick{
        void onClick(int position);
        void onLongClick(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(context).inflate(R.layout.teacher_item, parent,false);
        return new ViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Teacher teacher = teachers.get(position);
        holder.teacher.setText(teacher.getName());
        List<Semester> semesters = App.getInstance().getStudyDao().getSemesterByTeacher(teacher.getTeachId());
        String s = "";
        for (int i = 0; i < semesters.size(); i++) s += App.getInstance().getStudyDao().getSubjById(semesters.get(i).getSubjId()).getName() + " (" + semesters.get(i).getSemId() + " семестр) ";
        s = "Преподаваемые дисциплины: " + s;
        holder.subject.setText(s);
    }

    @Override
    public int getItemCount() {
        return teachers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView teacher;
        TextView subject;
        public ViewHolder(View itemView) {
            super(itemView);
            teacher = itemView.findViewById(R.id.teacher);
            subject = itemView.findViewById(R.id.subject);
        }
    }
}
