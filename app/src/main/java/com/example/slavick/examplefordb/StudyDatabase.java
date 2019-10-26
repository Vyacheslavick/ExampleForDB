package com.example.slavick.examplefordb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Student.class, Teacher.class, Discipline.class, Group.class, Semester.class, Mark.class}, version = 1)
public abstract class StudyDatabase extends RoomDatabase {
    public abstract StudyDao getStudyDao();
}
