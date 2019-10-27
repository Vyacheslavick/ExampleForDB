package com.example.slavick.examplefordb.Classes;

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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getSemId() {
        return semId;
    }

    public void setSemId(int semId) {
        this.semId = semId;
    }

    public int getTeachId() {
        return teachId;
    }

    public void setTeachId(int teachId) {
        this.teachId = teachId;
    }

    public int getSubjId() {
        return subjId;
    }

    public void setSubjId(int subjId) {
        this.subjId = subjId;
    }

    public String getOffSet() {
        return offSet;
    }

    public void setOffSet(String offSet) {
        this.offSet = offSet;
    }
}
