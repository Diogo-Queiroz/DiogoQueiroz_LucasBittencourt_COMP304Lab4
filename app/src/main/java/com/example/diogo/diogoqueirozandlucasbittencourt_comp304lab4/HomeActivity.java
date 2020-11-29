package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView nurseGreetingText;
    Nurse nurse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        nurse = (Nurse) getIntent().getSerializableExtra("Nurse");

        nurseGreetingText = findViewById(R.id.nurseGreetingText);
        nurseGreetingText.setText(getString(R.string.nurseGreeting, nurse.getFirstName()));

    }

    public void goToPatients(View v)
    {
        Intent intent = new Intent(this, PatientActivity.class);
        intent.putExtra("Nurse", nurse);
        startActivity(intent);
    }

}