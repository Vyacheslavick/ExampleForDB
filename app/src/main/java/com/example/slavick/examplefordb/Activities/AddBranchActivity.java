package com.example.slavick.examplefordb.Activities;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.slavick.examplefordb.Adapters.BranchAdapter;
import com.example.slavick.examplefordb.Classes.Branch;
import com.example.slavick.examplefordb.Classes.Student;
import com.example.slavick.examplefordb.R;
import com.example.slavick.examplefordb.SupportFeatures.App;

import java.util.List;

public class AddBranchActivity extends AppCompatActivity {

    Button addBranch;
    EditText branchEdit;
    EditText shortNameEdit;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_branch);
        addBranch = findViewById(R.id.add_branch);
        branchEdit = findViewById(R.id.branch_name_edit);
        shortNameEdit = findViewById(R.id.short_group_name_edit);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        addBranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Branch branch = App.getInstance().getStudyDao().getBranchWithName(branchEdit.getText().toString());
                if ((branchEdit.getText().toString().length() > 1)&&(shortNameEdit.getText().toString().length() > 0))
                    if(branch != null)
                        if(!branch.getFullName().equals(branchEdit.getText().toString())){
                             App.getInstance().getStudyDao().insertBranch(new Branch(branchEdit.getText().toString(), shortNameEdit.getText().toString()));
                             branchEdit.setText("");
                             shortNameEdit.setText("");
                        } else Toast.makeText(AddBranchActivity.this,"Такое отделение есть", Toast.LENGTH_SHORT).show();
                    else {
                        App.getInstance().getStudyDao().insertBranch(new Branch(branchEdit.getText().toString(), shortNameEdit.getText().toString()));
                        branchEdit.setText("");
                        shortNameEdit.setText("");
                    }
                else Toast.makeText(AddBranchActivity.this,"Вы что-то не ввели", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
