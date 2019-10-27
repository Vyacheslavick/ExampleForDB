package com.example.slavick.examplefordb.SupportFeatures;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.slavick.examplefordb.Classes.Discipline;
import com.example.slavick.examplefordb.Classes.Group;
import com.example.slavick.examplefordb.Classes.Mark;
import com.example.slavick.examplefordb.Classes.Semester;
import com.example.slavick.examplefordb.Classes.Student;
import com.example.slavick.examplefordb.Classes.Teacher;
import com.example.slavick.examplefordb.SupportFeatures.StudyDao;

@Database(entities = {Student.class, Teacher.class, Discipline.class, Group.class, Semester.class, Mark.class}, version = 1)
public abstract class StudyDatabase extends RoomDatabase {
    public abstract StudyDao getStudyDao();
}
