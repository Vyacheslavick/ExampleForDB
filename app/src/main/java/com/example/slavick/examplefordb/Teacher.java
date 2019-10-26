package com.example.slavick.examplefordb;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Teacher {

    @PrimaryKey(autoGenerate = true)
    int teachId;

    String name;

    public Teacher(String name) {
        this.name = name;
    }
}
