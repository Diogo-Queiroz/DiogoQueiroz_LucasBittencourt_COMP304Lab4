package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class HospitalRepository
{
    private PatientsDao mPatientsDao;
    private NurseDao mNurseDao;
    private TestDao mTestDao;

    private LiveData<List<Patient>> mAllPatients;
    private LiveData<List<Nurse>> mAllNurses;
    private LiveData<List<Patient>> mPatientForNurse;

    HospitalRepository(Application application)
    {
        HospitalDatabase db = HospitalDatabase.getDatabase(application);

        mPatientsDao = db.patientsDao();
        mNurseDao = db.nurseDao();
        mTestDao = db.testDao();

        mAllPatients = mPatientsDao.getAllPatients();
        mAllNurses = mNurseDao.getAllNurses();
    }

    LiveData<List<Patient>> getAllPatients() {return mAllPatients;}
    LiveData<List<Nurse>> getAllNurses() {return mAllNurses;}

    LiveData<List<Patient>> getPatientsForNurse(int nurseId)
    {
        return mPatientsDao.getPatientsByNurseId(nurseId);
    }

    LiveData<List<Patient>> getTestForPatientsForNurse(int nurseId)
    {
        mPatientForNurse = mTestDao.getTestForPatientForNurse(nurseId);
        return mPatientForNurse;
    }
    Nurse getNurseByUsername(String username)
    {
        return mTestDao.getNurseByUsername(username);
    }

    //INSERT METHODS
    void insertPatient(Patient patient)
    {
        HospitalDatabase.databaseWriteExecutor.execute(() ->
        {
            mPatientsDao.insert(patient);
        });
    }

    void insertNurse(Nurse nurse)
    {
        HospitalDatabase.databaseWriteExecutor.execute(() ->
        {
            mNurseDao.insert(nurse);
        });
    }

    //UPDATE METHODS
    void updatePatient(Patient patient)
    {
        HospitalDatabase.databaseWriteExecutor.execute(() ->
        {
            mPatientsDao.update(patient);
        });
    }

}
