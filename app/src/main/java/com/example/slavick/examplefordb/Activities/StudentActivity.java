package com.example.slavick.examplefordb.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.slavick.examplefordb.Adapters.StudentAdapter;
import com.example.slavick.examplefordb.Classes.Student;
import com.example.slavick.examplefordb.R;
import com.example.slavick.examplefordb.SupportFeatures.App;

import java.util.List;

public class StudentActivity extends AppCompatActivity implements StudentAdapter.StudentItemClick{

    List<Student> students;
    TextView nameGroup;
    RecyclerView studentList;
    StudentAdapter adapter;
    Button addStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        students = App.getInstance().getStudyDao().getStudentsFromGroup(getIntent().getIntExtra("group", 0));
        addStudent = findViewById(R.id.add_student);
        nameGroup = findViewById(R.id.name_group);
        nameGroup.setText(getIntent().getStringExtra("groupName"));
        studentList = findViewById(R.id.student_list);
        adapter = new StudentAdapter(StudentActivity.this, students,StudentActivity.this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(StudentActivity.this);
        studentList.setLayoutManager(layoutManager);
        studentList.setAdapter(adapter);
        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentActivity.this, AddStudentActivity.class);
                intent.putExtra("groupId", getIntent().getIntExtra("group", 0));
                startActivityForResult(intent, 7);
            }
        });
    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(StudentActivity.this, AddStudentActivity.class);
        intent.putExtra("groupId", getIntent().getIntExtra("group", 0));
        startActivityForResult(intent, 5);
    }

    @Override
    public void onLongClick(int position) {

    }
}
