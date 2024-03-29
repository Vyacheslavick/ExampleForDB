package com.example.slavick.examplefordb.Classes;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Group {

    @PrimaryKey(autoGenerate = true)
    int groupId;

    String shortName;
    int longNameId;

    public Group(String shortName, int longNameId) {
        this.shortName = shortName;
        this.longNameId = longNameId;
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

    public int getLongNameId() {
        return longNameId;
    }

    public void setLongNameId(int longNameId) {
        this.longNameId = longNameId;
    }
}
