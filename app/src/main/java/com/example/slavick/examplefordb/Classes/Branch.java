package com.example.slavick.examplefordb.Classes;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Branch {

    @PrimaryKey(autoGenerate = true)
    int fullNameId;


    String fullName;
    String shortName;

    public Branch(String fullName, String shortName) {

        this.fullName = fullName;
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getFullNameId() {
        return fullNameId;
    }

    public void setFullNameId(int fullNameId) {
        this.fullNameId = fullNameId;
    }

}
