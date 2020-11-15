package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentCourseDao
{
    @Insert
    void insert(StudentCourse studentCourse);

    @Query("SELECT * FROM student INNER JOIN student_course ON " +
            "student.studentId=student_course.stdId WHERE " +
            "student_course.crsCode=:crsCode")
        //the query parameter crsCode is passed as argument to this method
    LiveData<List<Student>> getStudentsForCourse(String crsCode);

    @Query("SELECT * FROM course INNER JOIN student_course ON " +
            "course.courseCode=student_course.crsCode WHERE " +
            "student_course.stdId=:stdId")
        //the query parameter stdId is passed as argument to this method
    LiveData<List<Course>> getCoursesForStudent(int stdId);
}
