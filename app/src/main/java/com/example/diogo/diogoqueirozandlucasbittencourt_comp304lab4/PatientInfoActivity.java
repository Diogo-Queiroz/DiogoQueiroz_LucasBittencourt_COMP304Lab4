package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PatientInfoActivity extends AppCompatActivity
{

    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);

        Patient patient = (Patient) getIntent().getSerializableExtra("Patient");

        name = findViewById(R.id.name);
        name.setText(patient.getFirstName());


    }
}