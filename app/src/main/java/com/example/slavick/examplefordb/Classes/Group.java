package com.example.slavick.examplefordb.Classes;

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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }
}
