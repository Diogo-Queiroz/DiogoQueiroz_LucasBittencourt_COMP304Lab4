package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TestDao
{
    @Insert
    void insert(Test test);

    @Update
    void update(Test test);

    @Query("select * from tests inner join patient on " +
            "tests.patientsId=:patientId where " +
            "tests.nurseId=:nurseId")
    LiveData<List<Test>> getTestsByPatientByNurse(int nurseId, int patientId);

    @Query("select * from nurse inner join tests on " +
            "nurse.nurseId=tests.nurseId where " +
            "tests.patientsId=:patientsId")
    LiveData<List<Nurse>> getTestPerStudent(int patientsId);

    @Query("select * from nurse where nurseUsername=:username")
    Nurse getNurseByUsername(String username);
}
