package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    private HospitalViewModel hospitalViewModel;
    private ArrayList<Patient> patientsList = new ArrayList<>();

    TextView nurseGreetingText, textViewNurseDepartment;
    Nurse nurse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        hospitalViewModel = new ViewModelProvider(this).get(HospitalViewModel.class);

        nurse = (Nurse) getIntent().getSerializableExtra("Nurse");

        nurseGreetingText = findViewById(R.id.nurseGreetingText);
        textViewNurseDepartment = findViewById(R.id.textViewDepartmentPlace);
        String output = (String.format("Hi %s, \n" +
                "Welcome to you home page.\n" +
                "Here you see how many patients you have. \n\n", nurse.getFirstName()) +
                "Clicking on the Patients button will take you to the list of patients under your responsibility.\n");
        nurseGreetingText.setText(output);
        textViewNurseDepartment.setText(String.format("Department:\n%s", nurse.getDepartment()));

    }

    public void goToPatients(View v)
    {
        Intent intent = new Intent(this, PatientActivity.class);
        intent.putExtra("Nurse", nurse);
        startActivity(intent);
    }

}