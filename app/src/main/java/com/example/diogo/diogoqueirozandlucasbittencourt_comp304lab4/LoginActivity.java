package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class LoginActivity extends AppCompatActivity
{
    private static final String TAG = "Login Activity";
    private Nurse nurse;
    private PatientViewModel patientViewModel;
    private List<Nurse> nurses;
    private EditText inputUsername, inputPassword;
    private TextView textViewError;
    private Button loginBtn;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        patientViewModel = new ViewModelProvider(this).get(PatientViewModel.class);
        nurse = new Nurse();

        inputUsername = findViewById(R.id.username_login);
        inputPassword = findViewById(R.id.password_login);
        loginBtn = findViewById(R.id.login_btn);
    }

    public void login(View view)
    {
        String username = inputUsername.getText().toString();
        String password = inputPassword.getText().toString();

        try
        {
            patientViewModel = new ViewModelProvider(this).get(PatientViewModel.class);
            Thread thread = new Thread(() ->
            {
                nurse = patientViewModel.getNurseByUsername(username);
                String name = "";
                name = nurse.getFirstName();
                if (nurse.getUsername().equals(username))
                {
                    Log.d(TAG, "the username is equal: " + nurse.getUsername());
                }
                if (nurse.getPassword().equals(password))
                {
                    Log.d(TAG, "the password is equal: " + nurse.getUsername());
                }
            });
        }
        catch (Error error)
        {
            textViewError.setText("Invalid Operation");
            Log.d(TAG, "Error -> " + error.getMessage());
        }

    }

    public void createAccountPage(View view)
    {

    }
}