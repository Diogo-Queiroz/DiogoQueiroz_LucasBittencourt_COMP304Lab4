package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Course
{
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "courseCode")
    private String courseCode;
    //
    @ColumnInfo(name = "courseName")
    private String courseName;
    //
    public Course()
    {

    }
    public Course(String courseCode, String courseName)
    {
        this.courseCode=courseCode;
        this.courseName=courseName;
    }
    //
    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
