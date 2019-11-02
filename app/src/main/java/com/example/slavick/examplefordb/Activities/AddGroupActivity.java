package com.example.slavick.examplefordb.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.slavick.examplefordb.Classes.Branch;
import com.example.slavick.examplefordb.Classes.Group;
import com.example.slavick.examplefordb.Classes.Student;
import com.example.slavick.examplefordb.R;
import com.example.slavick.examplefordb.SupportFeatures.App;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class AddGroupActivity extends AppCompatActivity {

    Branch branch;
    EditText shortName;
    Button addGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group);
        branch = App.getInstance().getStudyDao().getBranchWithId(getIntent().getIntExtra("branchId", 0));
        shortName = findViewById(R.id.edit_short_name);
        addGroup = findViewById(R.id.add_group);
        String s = branch.getShortName().concat("-");
        if (s != null)
            shortName.setText(s);
        addGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Group group = App.getInstance().getStudyDao().getGroupByName(shortName.getText().toString());
                if (shortName.getText().toString().length() > branch.getShortName().length() + 2)
                    if (group != null)
                        if(!group.getShortName().equals(shortName.getText().toString())){
                            App.getInstance().getStudyDao().insertGroup(new Group(shortName.getText().toString(), branch.getFullNameId()));
                            shortName.setText("");
                            shortName.setText(branch.getShortName());
                        } else Toast.makeText(AddGroupActivity.this,"Такая группа уже есть", Toast.LENGTH_SHORT).show();
                else {
                        App.getInstance().getStudyDao().insertGroup(new Group(shortName.getText().toString(), branch.getFullNameId()));
                        shortName.setText("");
                        shortName.setText(branch.getShortName());
                    }
                else Toast.makeText(AddGroupActivity.this,"Некорректное имя группы", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
