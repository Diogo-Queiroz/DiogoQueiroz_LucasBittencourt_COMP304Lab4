package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class PatientActivity extends AppCompatActivity implements PatientListAdapter.OnCardListener
{
    private HospitalViewModel hospitalViewModel;

    private PatientListAdapter patientListAdapter;

    private ArrayList<Patient> patientsList = new ArrayList<>();

    SharedPreferences preferences;
    int nurseId;

    private Handler handler;

    private EditText inputFirstName, inputLastName, inputDepartment, inputRoom;
    private Button insertBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        preferences = getSharedPreferences("nurseId", Context.MODE_PRIVATE);
        nurseId = preferences.getInt("nurseId", 0);
        handler = new Handler();

        inputFirstName = findViewById(R.id.input_patient_first_name);
        inputLastName = findViewById(R.id.input_patient_last_name);
        inputDepartment = findViewById(R.id.input_patient_department);
        inputRoom = findViewById(R.id.input_patient_room);

        initList();
        RecyclerView recyclerView = findViewById(R.id.patientRecyclerView);
        recyclerView.setHasFixedSize(true);
        patientListAdapter = new PatientListAdapter(this, patientsList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(patientListAdapter);

    }


    private void initList()
    {

        hospitalViewModel = new ViewModelProvider(this).get(HospitalViewModel.class);
        hospitalViewModel.getAllPatientsForNurse(nurseId).observe(this, new Observer<List<Patient>>() {
            @Override
            public void onChanged(List<Patient> patients) {
                patientsList.addAll(patients);
                patientListAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void onCardClick(int position) {
        Log.d("LOGGER", "clicked at position: " + position);

        Intent intent = new Intent(this, PatientInfoActivity.class);
        Patient patient = patientsList.get(position);
        intent.putExtra("Patient", patient);
        startActivity(intent);


    }

    public void insertPatient(View view)
    {
        String fName = inputFirstName.getText().toString();
        String lName = inputLastName.getText().toString();
        String dept = inputDepartment.getText().toString();
        String room = inputRoom.getText().toString();
        Patient patient = new Patient(fName, lName, dept, room, nurseId);

        hospitalViewModel.insertPatient(patient);
    }
}