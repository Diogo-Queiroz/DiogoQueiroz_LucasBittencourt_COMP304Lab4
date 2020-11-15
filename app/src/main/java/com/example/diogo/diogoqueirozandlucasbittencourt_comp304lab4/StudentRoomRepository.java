package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import android.app.Application;
import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;

public class StudentRoomRepository
{
    //Dao objects
    private StudentDao mStudentDao;
    private CourseDao mCourseDao;
    private StudentCourseDao mStudentCourseDao;
    // Variables to hold query results
    private LiveData<List<Student>> mAllStudents;
    private LiveData<List<Course>> mAllCourses;
    private LiveData<List<Student>> mStudentsForCourse;
    //
    // Note that in order to unit test the StudentRoomRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    StudentRoomRepository(Application application) {
        //create a database instance
        StudentRoomDatabase db = StudentRoomDatabase.getDatabase(application);
        //initialize Dao objects
        mStudentDao = db.studentDao();
        mCourseDao = db.courseDao();
        mStudentCourseDao = db.studentCourseDao();
        //get all students
        mAllStudents = mStudentDao.getAllStudents();
        //get all courses
        mAllCourses = mCourseDao.getAllCourses();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Student>> getAllStudents() {
        return mAllStudents;
    }
    LiveData<List<Course>> getAllCourses() {
        return mAllCourses;
    }
    //
    LiveData<List<Student>> getStudentsForCourse(String crsCode)
    {
        //return the results from JOIN table
        mStudentsForCourse = mStudentCourseDao.getStudentsForCourse(crsCode);
        return mStudentsForCourse;

    }


    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insertStudent(Student student) {
        StudentRoomDatabase.databaseWriteExecutor.execute(() -> {
            mStudentDao.insert(student);
        });
    }
    //
    void insertCourse(Course course) {
        StudentRoomDatabase.databaseWriteExecutor.execute(() -> {
            mCourseDao.insert(course);
        });
    }
}
