package com.example.slavick.examplefordb.Classes;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity
public class Student implements Comparable<Student> {

    @PrimaryKey(autoGenerate = true)
    int studId;

    String name;
    String sername;
    String fathers;
    int groupId;

    public int getStudId() {
        return studId;
    }

    public void setStudId(int studId) {
        this.studId = studId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getFathers() {

        return fathers;
    }

    public void setFathers(String fathers) {
        this.fathers = fathers;
    }

    public String getSername() {

        return sername;
    }

    public void setSername(String sername) {
        this.sername = sername;
    }

    public Student(String name, String sername, String fathers, int groupId) {

        this.name = name;
        this.sername = sername;
        this.fathers = fathers;
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(@NonNull Student o) {
        return name.compareTo(o.name);
    }
}
