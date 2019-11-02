package com.example.slavick.examplefordb.SupportFeatures;

import android.app.Application;
import android.arch.persistence.room.Room;

public class App extends Application {
    public static App instance;
    private StudyDao studyDao;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        StudyDatabase studyDatabase = Room.databaseBuilder(getApplicationContext(), StudyDatabase.class, "Database").allowMainThreadQueries().build();
        studyDao = studyDatabase.getStudyDao();
    }

    public static App getInstance() {
        return instance;
    }

    public StudyDao getStudyDao() {
        return studyDao;
    }
}
