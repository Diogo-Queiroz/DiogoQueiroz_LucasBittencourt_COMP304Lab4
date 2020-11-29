package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PatientInfoActivity extends AppCompatActivity
{

    EditText firstName, lastName, department, room;
    Button addOrUpdateBtn, testBtn;
    SharedPreferences preferences;
    int nurseId;
    int patientId;
    private HospitalViewModel hospitalViewModel;
    Nurse nurse;
    Patient patient;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);
        //nurse = (Nurse) getIntent().getSerializableExtra("Nurse");
        hospitalViewModel = new ViewModelProvider(this).get(HospitalViewModel.class);

        preferences = getSharedPreferences("nurseId", Context.MODE_PRIVATE);
        nurseId = preferences.getInt("nurseId", 0);
        patientId = preferences.getInt("patientId", 0);

        addOrUpdateBtn = findViewById(R.id.add_or_update_test);
        testBtn = findViewById(R.id.test_btn);

        firstName = findViewById(R.id.input_nurse_name);
        lastName = findViewById(R.id.input_test_temp);
        department = findViewById(R.id.input_test_BPH);
        room = findViewById(R.id.input_test_BPL);

        patient = (Patient) getIntent().getSerializableExtra("Patient");
        if (patient == null)
        {
            addOrUpdateBtn.setText("INSERT");
            addOrUpdateBtn.setOnClickListener(this::insertPatient);
            testBtn.setVisibility(View.GONE);
        }
        else
        {
            addOrUpdateBtn.setText("UPDATE");
            addOrUpdateBtn.setOnClickListener(this::updatePatient);
            testBtn.setVisibility(View.VISIBLE);
            firstName.setText(patient.getFirstName());
            lastName.setText(patient.getLastName());
            department.setText(patient.getDepartment());
            room.setText(patient.getRoom());
        }

    }

    public void back(View view)
    {
        finish();
    }

    public void insertPatient(View view)
    {
        String fName = firstName.getText().toString();
        String lName = lastName.getText().toString();
        String dept = department.getText().toString();
        String roomStr = room.getText().toString();
        Patient patient = new Patient(fName, lName, dept, roomStr, nurseId);

        hospitalViewModel.insertPatient(patient);
        Log.d("TAG", "insert???????????");
        finish();
    }

    public void updatePatient(View view)
    {
        patient.setFirstName(firstName.getText().toString());
        patient.setLastName(lastName.getText().toString());
        patient.setDepartment(department.getText().toString());
        patient.setRoom(room.getText().toString());
        patient.setNurseId(nurseId);

        hospitalViewModel.updatePatient(patient);
        Log.d("TAG", "Update???????????");
        finish();
    }

    public void patientTest(View view)
    {
        Intent intent = new Intent(this, TestActivity.class);
        //intent.putExtra("Nurse", nurse);
        intent.putExtra("Patient", patient);
        startActivity(intent);
    }
}