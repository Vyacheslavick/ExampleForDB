package com.example.slavick.examplefordb;

import android.arch.persistence.room.Entity;

@Entity(primaryKeys = {"studId", "semId", "subjId"})
public class Mark {

    int studId;
    int semId;
    int subjId;

    int mark;

    public Mark(int studId, int semId, int subjId, int mark) {
        this.studId = studId;
        this.semId = semId;
        this.subjId = subjId;
        this.mark = mark;
    }
}
