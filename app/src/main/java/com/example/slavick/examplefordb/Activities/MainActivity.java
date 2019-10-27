package com.example.slavick.examplefordb.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.slavick.examplefordb.Classes.Discipline;
import com.example.slavick.examplefordb.R;

public class MainActivity extends AppCompatActivity {

    TextView teachers;
    TextView groups;
    TextView disciplines;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teachers = findViewById(R.id.teachers);
        groups = findViewById(R.id.groups);
        disciplines = findViewById(R.id.disciplines);

        teachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TeacherActivity.class);
                startActivity(intent);
            }
        });

        groups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GroupActivity.class);
                startActivity(intent);
            }
        });

        disciplines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DisciplineActivity.class);
                startActivity(intent);
            }
        });
    }
}
