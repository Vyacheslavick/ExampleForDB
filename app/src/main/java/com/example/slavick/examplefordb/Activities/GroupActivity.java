package com.example.slavick.examplefordb.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.slavick.examplefordb.Adapters.GroupAdapter;
import com.example.slavick.examplefordb.Classes.Group;
import com.example.slavick.examplefordb.R;
import com.example.slavick.examplefordb.SupportFeatures.App;

import java.util.List;

public class GroupActivity extends AppCompatActivity implements GroupAdapter.GroupItemClick{

    Button addGroup;
    List<Group> groups ;
    RecyclerView groupList;
    GroupAdapter groupAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        groups = App.getInstance().getStudyDao().getAllGroups();
        addGroup = findViewById(R.id.add_group);
        groupList = findViewById(R.id.group_list);
        addGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GroupActivity.this, AddGroupActivity.class);
                intent.putExtra("branchId", getIntent().getIntExtra("branch", 0));
                startActivityForResult(intent, 2);
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(GroupActivity.this);
        groupList.setLayoutManager(layoutManager);
        groupAdapter = new GroupAdapter(GroupActivity.this, groups, GroupActivity.this);
        groupList.setAdapter(groupAdapter);

    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(GroupActivity.this, StudentActivity.class);
        intent.putExtra("group", groups.get(position).getGroupId());
        intent.putExtra("groupName", groups.get(position).getShortName());
        startActivityForResult(intent,1);
    }

    @Override
    public void onLongClick(int position) {

    }
}
