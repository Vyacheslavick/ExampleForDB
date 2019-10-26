package com.example.slavick.examplefordb;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Student {

    @PrimaryKey(autoGenerate = true)
    int studId;

    String name;

    public Student(String name) {
        this.name = name;
    }

}
