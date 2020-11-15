package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDao
{
    @Insert
    void insert(Student student);
    //Monitoring Query Result Changes with Live Data
    @Query("select * from Student order by name")
    LiveData<List<Student>> getAllStudents();
}
