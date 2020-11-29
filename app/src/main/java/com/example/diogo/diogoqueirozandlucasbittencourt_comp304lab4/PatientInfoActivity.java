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
    Button addOrUpdateBtn, backBtn;
    SharedPreferences preferences;
    int nurseId;
    private HospitalViewModel hospitalViewModel;
    Nurse nurse;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);
        nurse = (Nurse) getIntent().getSerializableExtra("Nurse");
        hospitalViewModel = new ViewModelProvider(this).get(HospitalViewModel.class);

        preferences = getSharedPreferences("nurseId", Context.MODE_PRIVATE);
        nurseId = preferences.getInt("nurseId", 0);

        addOrUpdateBtn = findViewById(R.id.add_or_update_info);

        firstName = findViewById(R.id.input_patient_first_name);
        lastName = findViewById(R.id.input_patient_last_name);
        department = findViewById(R.id.input_patient_department);
        room = findViewById(R.id.input_patient_room);

        Patient patient = (Patient) getIntent().getSerializableExtra("Patient");
        if (patient == null)
        {
            addOrUpdateBtn.setText("INSERT");
            addOrUpdateBtn.setOnClickListener(this::insertPatient);
        }
        else
        {
            addOrUpdateBtn.setText("UPDATE");
            addOrUpdateBtn.setOnClickListener(this::updatePatient);

            firstName.setText(patient.getFirstName());
            lastName.setText(patient.getLastName());
            department.setText(patient.getDepartment());
            room.setText(patient.getRoom());
        }

    }

    public void back(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        //intent.putExtra("Nurse", nurse);
        startActivity(intent);
    }

    public void updatePatient(View view)
    {
        String fName = firstName.getText().toString();
        String lName = lastName.getText().toString();
        String dept = department.getText().toString();
        String roomStr = room.getText().toString();
        Patient patient = new Patient(fName, lName, dept, roomStr, nurseId);

        hospitalViewModel.updatePatient(patient);
        Log.d("TAG", "Updated???????????");
        back(view);
    }

    public void insertPatient(View view)
    {
        String fName = firstName.getText().toString();
        String lName = lastName.getText().toString();
        String dept = department.getText().toString();
        String roomStr = room.getText().toString();
        Patient patient = new Patient(fName, lName, dept, roomStr, nurseId);

        hospitalViewModel.insertPatient(patient);
        Log.d("TAG", "Inserted???????????");
        back(view);
    }
}