package com.example.slavick.examplefordb.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.slavick.examplefordb.R;

public class DisciplineActivity extends AppCompatActivity {

    Button addSubj;
    RecyclerView disciplines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discipline);
        disciplines = findViewById(R.id.disciplines);
        addSubj = findViewById(R.id.add_discipline);
        addSubj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisciplineActivity.this, AddDisciplineActivity.class);
                startActivityForResult(intent,2);
            }
        });
    }
}
