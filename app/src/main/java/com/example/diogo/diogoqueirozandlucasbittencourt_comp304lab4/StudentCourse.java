package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "student_course",
        primaryKeys = { "stdId", "crsCode" },
        foreignKeys = {
                @ForeignKey(entity = Student.class,
                        parentColumns = "studentId",
                        childColumns = "stdId"),
                @ForeignKey(entity = Course.class,
                        parentColumns = "courseCode",
                        childColumns = "crsCode")
        })
public class StudentCourse
{
    private int stdId;
    @NonNull
    private String crsCode;
    //
    public StudentCourse(int stdId, String crsCode)
    {
        this.stdId=stdId;
        this.crsCode=crsCode;

    }
    public int getStdId(){return stdId;}
    public String getCrsCode(){return crsCode;}
}
