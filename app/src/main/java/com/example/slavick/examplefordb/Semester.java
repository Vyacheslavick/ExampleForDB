package com.example.slavick.examplefordb;

import android.arch.persistence.room.Entity;

@Entity(primaryKeys = {"groupId","semId","subjId"})
public class Semester {

    int groupId;
    int semId;
    int teachId;
    int subjId;
    String offSet;

    public Semester(int groupId, int semId, int teachId, int subjId, String offSet) {
        this.groupId = groupId;
        this.semId = semId;
        this.teachId = teachId;
        this.subjId = subjId;
        this.offSet = offSet;
    }
}
