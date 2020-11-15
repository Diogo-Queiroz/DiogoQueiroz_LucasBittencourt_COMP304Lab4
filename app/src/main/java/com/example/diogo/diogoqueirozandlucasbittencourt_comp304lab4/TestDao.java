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

    @Query("select * from patient inner join test on " +
            "patient.patientsId=test.patientsId where " +
            "test.nurseId=:nurseId")
    LiveData<List<Patient>> getPatientForNurse(int nurseId);

    @Query("select * from nurse inner join test on " +
            "nurse.nurseId=test.nurseId where " +
            "test.patientsId=:patientsId")
    LiveData<List<Nurse>> getTestPerStudent(int patientsId);
}
