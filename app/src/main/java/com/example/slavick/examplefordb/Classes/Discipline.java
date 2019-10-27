package com.example.slavick.examplefordb.Classes;

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

    public int getSubjId() {
        return subjId;
    }

    public void setSubjId(int subjId) {
        this.subjId = subjId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
