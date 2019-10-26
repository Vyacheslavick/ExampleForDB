package com.example.slavick.examplefordb;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity
public class Student implements Comparable<Student> {

    @PrimaryKey(autoGenerate = true)
    int studId;

    String name;
    int groupId;

    public Student(String name, int groupId) {
        this.name = name;
        this.groupId = groupId;
    }

    @Override
    public int compareTo(@NonNull Student o) {
        return name.compareTo(o.name);
    }
}
