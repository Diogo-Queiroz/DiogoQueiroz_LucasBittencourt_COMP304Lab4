package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PatientsDao
{
    @Insert
    void insert(Patient patient);

    @Query("select * from Patient order by firstName")
    LiveData<List<Patient>> getAllPatients();

    @Query("select * from Patient where nurseId = :nurseId")
    LiveData<List<Patient>> getPatientsByNurseId(int nurseId);

}
