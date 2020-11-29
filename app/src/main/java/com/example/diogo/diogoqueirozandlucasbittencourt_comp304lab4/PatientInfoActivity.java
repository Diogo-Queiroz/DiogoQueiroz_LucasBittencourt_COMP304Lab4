package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PatientInfoActivity extends AppCompatActivity
{

    EditText firstName, lastName, department, room;
    Button updateInfo, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);

        Patient patient = (Patient) getIntent().getSerializableExtra("Patient");

        firstName = findViewById(R.id.input_patient_first_name);
        firstName.setText(patient.getFirstName());

        lastName = findViewById(R.id.input_patient_last_name);
        lastName.setText(patient.getLastName());

        department = findViewById(R.id.input_patient_department);
        department.setText(patient.getDepartment());

        room = findViewById(R.id.input_patient_room);
        room.setText(patient.getRoom());
    }

    public void back(View view)
    {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void updatePatient(View view)
    {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}