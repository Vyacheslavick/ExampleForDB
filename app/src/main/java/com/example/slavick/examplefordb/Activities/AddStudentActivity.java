package com.example.slavick.examplefordb.Activities;


import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.slavick.examplefordb.Classes.Student;
import com.example.slavick.examplefordb.R;
import com.example.slavick.examplefordb.SupportFeatures.App;

public class AddStudentActivity extends AppCompatActivity {

    EditText editName;
    EditText editSername;
    EditText editFathers;
    Button addStudent;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        editName = findViewById(R.id.edit_name);
        editSername = findViewById(R.id.edit_sername);
        editFathers = findViewById(R.id.edit_fathers);
        addStudent = findViewById(R.id.add_student);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Student student = App.getInstance().getStudyDao().getStudWithName(editName.getText().toString(), editSername.getText().toString(), editFathers.getText().toString());
               if ((editName.getText().toString().length() > 1)&&(editSername.getText().toString().length() > 1)&&(editFathers.getText().toString().length() > 1))
                   if(student != null)
                        if((!student.getName().equals(editName.getText().toString()))||(!student.getName().equals(editName.getText().toString())||(!student.getName().equals(editName.getText().toString())))) {
                            App.getInstance().getStudyDao().insertStud(new Student(editName.getText().toString(), editSername.getText().toString(), editFathers.getText().toString(), getIntent().getIntExtra("groupId", 0)));
                            editName.setText("");
                            editSername.setText("");
                            editFathers.setText("");
                        } else Toast.makeText(AddStudentActivity.this,"Такой студент уже есть", Toast.LENGTH_SHORT).show();
                    else{
                       App.getInstance().getStudyDao().insertStud(new Student(editName.getText().toString(), editSername.getText().toString(), editFathers.getText().toString(), getIntent().getIntExtra("groupId", 0)));
                       editName.setText("");
                       editSername.setText("");
                       editFathers.setText("");
                   }
               else Toast.makeText(AddStudentActivity.this,"Вы что-то не ввели", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
