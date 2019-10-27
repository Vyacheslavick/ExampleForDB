package com.example.slavick.examplefordb.Classes;

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

    public int getStudId() {
        return studId;
    }

    public void setStudId(int studId) {
        this.studId = studId;
    }

    public int getSemId() {
        return semId;
    }

    public void setSemId(int semId) {
        this.semId = semId;
    }

    public int getSubjId() {
        return subjId;
    }

    public void setSubjId(int subjId) {
        this.subjId = subjId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
