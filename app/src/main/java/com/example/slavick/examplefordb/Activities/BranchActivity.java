package com.example.slavick.examplefordb.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.slavick.examplefordb.Adapters.BranchAdapter;
import com.example.slavick.examplefordb.Classes.Branch;
import com.example.slavick.examplefordb.R;
import com.example.slavick.examplefordb.SupportFeatures.App;

import java.util.List;

public class BranchActivity extends AppCompatActivity implements BranchAdapter.BranchesItemClick {

    RecyclerView branchList;
    List<Branch> branches;
    Button addBranch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        branches = App.getInstance().getStudyDao().getAllBranches();
        setContentView(R.layout.activity_branch);
        addBranch = findViewById(R.id.add_branch);
        addBranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BranchActivity.this, AddBranchActivity.class);
                startActivityForResult(intent, 5);
            }
        });

        branchList = findViewById(R.id.branches);
        LinearLayoutManager layoutManager = new LinearLayoutManager(BranchActivity.this);
        branchList.setLayoutManager(layoutManager);
        BranchAdapter branchAdapter = new BranchAdapter(branches, BranchActivity.this, BranchActivity.this);
        branchList.setAdapter(branchAdapter);
    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(BranchActivity.this, GroupActivity.class);
        intent.putExtra("branch", branches.get(position).getFullNameId());
        startActivity(intent);
    }

    @Override
    public void onLongClick(int position) {

    }
}
