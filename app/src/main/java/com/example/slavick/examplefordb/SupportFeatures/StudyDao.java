package com.example.slavick.examplefordb.SupportFeatures;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.slavick.examplefordb.Classes.Discipline;
import com.example.slavick.examplefordb.Classes.Group;
import com.example.slavick.examplefordb.Classes.Mark;
import com.example.slavick.examplefordb.Classes.Semester;
import com.example.slavick.examplefordb.Classes.Student;
import com.example.slavick.examplefordb.Classes.Teacher;

import java.util.List;
import java.util.TreeSet;

@Dao
public interface StudyDao {

    //Requests for Student
    @Query("Select * From student")
    TreeSet<Student> getAllStudents();

    @Query("Select * From student where studId = :studId")
    Student getStudById(int studId);

    @Query("Select * From student where groupId = :groupId")
    List<Student> getStudentsFromGroup(int groupId);

    @Insert
    Student insertStud(Student student);

    @Delete
    Student deleteStud(Student student);

    @Update
    Student updateStud(Student student);

    //Requests for Teacher
    @Query("Select * From teacher")
    List<Teacher> getAllTeachers();

    @Query("Select * From teacher where teachId = :teachId")
    Teacher getTeachById(int teachId);

    @Insert
    Teacher insertTeach(Teacher teacher);

    @Delete
    Teacher deleteTeach(Teacher teacher);

    @Update
    Teacher updateTeach(Teacher teacher);

    //Requests for Group
    @Query("Select * From `Group`")
    List<Group> getAllGroups();

    @Query("Select * From `group` where groupId = :groupId")
    Group getGroupById(int groupId);

    @Insert
    Group insertGroup(Group group);

    @Delete
    Group deleteGroup(Group group);

    @Update
    Group updateGroup(Group group);

    //Requests for Discipline
    @Query("Select * From discipline")
    List<Discipline> getAllSubjects();

    @Query("Select * From discipline where subjId = :subjId")
    Discipline getSubjById(int subjId);

    @Insert
    Discipline insertSubj(Discipline discipline);

    @Delete
    Discipline deleteSubj(Discipline discipline);

    @Update
    Discipline updateSubj(Discipline discipline);

    //Requests for Semester
    @Query("Select * From semester")
    List<Semester> getAllSemesters();

    @Query("Select * From semester where subjId = :subjId and semId = :semId and groupId = :groupId")
    Semester getSemesterById(int subjId, int semId, int groupId);

    @Query("Select * From semester where teachId = :teachId")
    List<Semester> getSemesterByTeacher(int teachId);

    @Insert
    Semester insertSemester(Semester semester);

    @Delete
    Semester deleteSemester(Semester semester);

    @Update
    Semester updateSemester(Semester semester);

    //Requests for Mark
    @Query("Select * From mark")
    List<Mark> getAllMarks();

    @Query("Select * From mark where subjId = :subjId and semId = :semId and studId = :studId")
    Mark getMarkById(int subjId, int semId, int studId);

    @Insert
    Semester insertMark(Semester semester);

    @Delete
    Semester deleteMark(Semester semester);

    @Update
    Semester updateMark(Semester semester);


}
