package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TestDao
{
    @Insert
    void insert(Test test);

    @Query("select * from patient inner join tests on " +
            "patient.patientsId=tests.patientsId where " +
            "tests.nurseId=:nurseId")
    LiveData<List<Patient>> getPatientForNurse(int nurseId);

    @Query("select * from nurse inner join tests on " +
            "nurse.nurseId=tests.nurseId where " +
            "tests.patientsId=:patientsId")
    LiveData<List<Nurse>> getTestPerStudent(int patientsId);
}
