package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CourseDao
{
    //
    @Query("SELECT * FROM Course")
    LiveData<List<Course>> getAllCourses();
    //
    @Insert
    void insert(Course... courses);
    //
    @Update
    void update(Course... courses);
    //
    @Delete
    void delete(Course... courses);
}
