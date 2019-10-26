package com.example.slavick.examplefordb;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Discipline {

    @PrimaryKey(autoGenerate = true)
    int subjId;

    String name;

    public Discipline(String name) {
        this.name = name;
    }
}
