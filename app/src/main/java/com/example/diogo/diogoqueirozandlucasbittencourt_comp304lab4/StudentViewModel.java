package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class StudentViewModel
    extends AndroidViewModel
{
    //repository object
    private StudentRoomRepository mRepository;
    // query results
    private LiveData<List<Student>> mAllStudents;
    private LiveData<List<Course>> mAllCourses;
    private LiveData<List<Student>> mStudentsForCourse;
    //
    public StudentViewModel (Application application) {
        super(application);
        mRepository = new StudentRoomRepository(application);
        //get all students
        mAllStudents = mRepository.getAllStudents();
        //get all courses
        mAllCourses = mRepository.getAllCourses();
    }
    //query methods to be called from main activity
    LiveData<List<Student>> getAllStudents() { return mAllStudents; }
    LiveData<List<Course>> getAllCourses() { return mAllCourses; }
    LiveData<List<Student>> getAllStudentsForCourse(String crsCode)
    {
        mStudentsForCourse = mRepository.getStudentsForCourse(crsCode);
        return mStudentsForCourse;
    }
    //
    public void insertStudent(Student student) { mRepository.insertStudent(student); }
    public void insertCourse(Course course) { mRepository.insertCourse(course); }
}
