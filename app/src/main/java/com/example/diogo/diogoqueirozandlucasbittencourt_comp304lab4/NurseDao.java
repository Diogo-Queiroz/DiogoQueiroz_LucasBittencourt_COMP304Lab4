package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NurseDao
{
    @Query("select * from Nurse")
    LiveData<List<Nurse>> getAllNurses();

    @Insert
    void insert(Nurse... nurses);

    @Update
    void update(Nurse... nurses);

    @Delete
    void delete(Nurse... nurses);
}
