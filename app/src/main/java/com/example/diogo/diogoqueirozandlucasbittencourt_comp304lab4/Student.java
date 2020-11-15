package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student
{
    @PrimaryKey
    @ColumnInfo(name = "studentId")
    private int studentId;
    //
    @ColumnInfo(name = "name")
    private String name;
    public Student()
    {

    }
    //
    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }
    //
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
