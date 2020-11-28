package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TestRoomRepository
{
    private PatientsDao mPatientsDao;
    private NurseDao mNurseDao;
    private TestDao mTestDao;

    private LiveData<List<Patient>> mAllPatients;
    private LiveData<List<Nurse>> mAllNurses;
    private LiveData<List<Patient>> mPatientForNurse;

    TestRoomRepository(Application application)
    {
        TestRoomDatabase db = TestRoomDatabase.getDatabase(application);

        mPatientsDao = db.patientsDao();
        mNurseDao = db.nurseDao();
        mTestDao = db.testDao();

        mAllPatients = mPatientsDao.getAllPatients();
        mAllNurses = mNurseDao.getAllNurses();
    }

    LiveData<List<Patient>> getAllPatients() {return mAllPatients;}
    LiveData<List<Nurse>> getAllNurses() {return mAllNurses;}
    LiveData<List<Patient>> getStudentForNurse(int nurseId)
    {
        mPatientForNurse = mTestDao.getPatientForNurse(nurseId);
        return mPatientForNurse;
    }
    Nurse getNurseByUsername(String username)
    {
        return mTestDao.getNurseByUsername(username);
    }

    void insertPatient(Patient patient)
    {
        TestRoomDatabase.databaseWriteExecutor.execute(() ->
        {
            mPatientsDao.insert(patient);
        });
    }

    void insertNurse(Nurse nurse)
    {
        TestRoomDatabase.databaseWriteExecutor.execute(() ->
        {
            mNurseDao.insert(nurse);
        });
    }

}
