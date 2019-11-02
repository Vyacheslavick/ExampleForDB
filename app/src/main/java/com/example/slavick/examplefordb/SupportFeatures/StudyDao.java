package com.example.slavick.examplefordb.SupportFeatures;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.slavick.examplefordb.Classes.Branch;
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
    List<Student> getAllStudents();

    @Query("Select * From student where studId = :studId")
    Student getStudById(int studId);

    @Query("Select * From student where name = :name and sername = :sername and fathers = :fathers")
    Student getStudWithName(String name, String sername, String fathers);

    @Query("Select * From student where groupId = :groupId")
    List<Student> getStudentsFromGroup(int groupId);

    @Insert
    void insertStud(Student student);

    @Delete
    void deleteStud(Student student);

    @Update
    void updateStud(Student student);

    //Requests for Teacher
    @Query("Select * From teacher")
    List<Teacher> getAllTeachers();

    @Query("Select * From teacher where teachId = :teachId")
    Teacher getTeachById(int teachId);

    @Insert
    void insertTeach(Teacher teacher);

    @Delete
    void deleteTeach(Teacher teacher);

    @Update
    void updateTeach(Teacher teacher);

    //Requests for Group
    @Query("Select * From `Group`")
    List<Group> getAllGroups();

    @Query("Select * From `group` where groupId = :groupId")
    Group getGroupById(int groupId);

    @Query("Select * from `group` where shortName = :shortName")
    Group getGroupByName(String shortName);

    @Insert
    void insertGroup(Group group);

    @Delete
    void deleteGroup(Group group);

    @Update
    void updateGroup(Group group);

    //Requests for Discipline
    @Query("Select * From discipline")
    List<Discipline> getAllSubjects();

    @Query("Select * From discipline where subjId = :subjId")
    Discipline getSubjById(int subjId);

    @Insert
    void insertSubj(Discipline discipline);

    @Delete
    void deleteSubj(Discipline discipline);

    @Update
    void updateSubj(Discipline discipline);

    //Requests for Semester
    @Query("Select * From semester")
    List<Semester> getAllSemesters();

    @Query("Select * From semester where subjId = :subjId and semId = :semId and groupId = :groupId")
    Semester getSemesterById(int subjId, int semId, int groupId);

    @Query("Select * From semester where teachId = :teachId")
    List<Semester> getSemesterByTeacher(int teachId);

    @Insert
    void insertSemester(Semester semester);

    @Delete
    void deleteSemester(Semester semester);

    @Update
    void updateSemester(Semester semester);

    //Requests for Mark
    @Query("Select * From mark")
    List<Mark> getAllMarks();

    @Query("Select * From mark where subjId = :subjId and semId = :semId and studId = :studId")
    Mark getMarkById(int subjId, int semId, int studId);

    @Insert
    void insertMark(Mark mark);

    @Delete
    void deleteMark(Mark mark);

    @Update
    void updateMark(Mark mark);

    //Branch requests

    @Query("Select * From branch")
    List<Branch> getAllBranches();

    @Query("Select * From branch where fullNameId = :branchId")
    Branch getBranchWithId(int branchId);

    @Query("Select * From branch where fullName = :fullName")
    Branch getBranchWithName(String fullName);

    @Insert
    void insertBranch(Branch branch);

    @Delete
    void deleteBranch(Branch branch);

    @Update
    void updateBranch(Branch branch);

}
