package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity
{
    private static final String TAG = "Register Activity";
    private PatientViewModel patientViewModel;
    private Button createAccount, backToLoginPage;
    private EditText editTextNurseUsername, editTextNurseName, editTextNurseLastName,
                     editTextNurseDepartment, editTextNursePassword;
    Nurse nurse;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        createAccount = findViewById(R.id.login_btn);
        patientViewModel = new ViewModelProvider(this).get(PatientViewModel.class);
        nurse = new Nurse();
    }

    public void insertNurse(View view)
    {
        editTextNurseUsername = findViewById(R.id.username_login);
        editTextNurseName = findViewById(R.id.firstName_input);
        editTextNurseLastName = findViewById(R.id.lastName_input);
        editTextNurseDepartment = findViewById(R.id.department_input);
        editTextNursePassword = findViewById(R.id.password_login);

        nurse.setUsername(editTextNurseUsername.getText().toString());
        nurse.setFirstName(editTextNurseName.getText().toString());
        nurse.setLastName(editTextNurseLastName.getText().toString());
        nurse.setDepartment(editTextNurseDepartment.getText().toString());
        nurse.setPassword(editTextNursePassword.getText().toString());

        patientViewModel.insertNurse(nurse);
        Log.d(TAG, "the value is: " + nurse.getFirstName());

    }

    public void backToMainPage(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}