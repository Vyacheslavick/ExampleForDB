package com.example.slavick.examplefordb;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Group {

    @PrimaryKey(autoGenerate = true)
    int groupId;

    String shortName;
    String longName;

    public Group(String shortName, String longName) {
        this.shortName = shortName;
        this.longName = longName;
    }
}
