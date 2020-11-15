package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PatientViewModel
    extends AndroidViewModel
{
    private TestRoomRepository mRepository;

    private LiveData<List<Patient>> mAllPatients;
    private LiveData<List<Nurse>> mAllNurses;
    private LiveData<List<Patient>> mPatientForNurse;

    public PatientViewModel(Application application)
    {
        super(application);
        mRepository = new TestRoomRepository(application);
        mAllPatients = mRepository.getAllPatients();
        mAllNurses = mRepository.getAllNurses();
    }

    LiveData<List<Patient>> getAllPatients() {return mAllPatients;}
    LiveData<List<Nurse>> getAllNurses() {return mAllNurses;}
    LiveData<List<Patient>> getAllPatientsForNurse(int nurseId)
    {
        mPatientForNurse = mRepository.getStudentForNurse(nurseId);
        return mPatientForNurse;
    }

    public void insertPatient(Patient patient) { mRepository.insertPatient(patient); }
    public void insertNurse(Nurse nurse) { mRepository.insertNurse(nurse); }
}
