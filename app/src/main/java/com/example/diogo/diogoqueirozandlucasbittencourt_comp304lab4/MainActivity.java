package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "Main Activity";
    private PatientViewModel patientViewModel;
    private Button btnInsertPatient;
    private EditText editTextPatientId, editTextPatientName;
    private EditText editTextNurseId, editTextNurseName;
    private TextView textViewDisplayPatient, textViewDisplayNurse;
    Patient patient;
    Nurse nurse;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //writeIntoDatabase();

        textViewDisplayPatient = findViewById(R.id.textViewDisplayPatient);
        textViewDisplayNurse = findViewById(R.id.textViewDisplayNurse);

        patientViewModel = new ViewModelProvider(this).get(PatientViewModel.class);
        patient = new Patient();
        nurse = new Nurse();

        patientViewModel.getAllPatients().observe(this, new Observer<List<Patient>>()
        {
            @Override
            public void onChanged(List<Patient> patients)
            {
                String output = "";
                for (Patient patient : patients)
                {
                    output += patient.getName() + "\n";
                }
                textViewDisplayPatient.setText(output);
            }
        });
    }
    public void insertStudent(View view)
    {
        editTextPatientId = findViewById(R.id.editTextPatientId);
        patient.setPatientsId(Integer.parseInt(editTextPatientId.getText().toString()));

        editTextPatientName = findViewById(R.id.editTextPatientName);
        patient.setName(editTextPatientName.getText().toString());

        patientViewModel.insertPatient(patient);
    }

    public void insertNurse(View view)
    {
        editTextNurseId = findViewById(R.id.editTextNurseId);
        nurse.setNurseId(Integer.parseInt(editTextNurseId.getText().toString()));

        editTextNurseName = findViewById(R.id.editTextNurseName);
        nurse.setName(editTextNurseName.getText().toString());

        patientViewModel.insertNurse(nurse);
    }

    public void getList(View view)
    {
        patientViewModel.getAllPatients().observe(this, new Observer<List<Patient>>() {
            @Override
            public void onChanged(@Nullable List<Patient> patients) {
                String  output="";

                for(Patient patient : patients) {
                    output += patient.getName() +"\n";
                }
                textViewDisplayPatient.setText(output);
            }
        });
        //
        patientViewModel.getAllNurses().observe(this, new Observer<List<Nurse>>() {
            @Override
            public void onChanged(@Nullable List<Nurse> nurses) {
                String  output="";

                for(Nurse nurse : nurses) {
                    output += nurse.getName() +"\n";
                }
                textViewDisplayNurse.setText(output);
            }
        });
    }

    // Firebase write and read from database realtime
    public void writeIntoDatabase()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("message");
        DatabaseReference patients = database.getReference().child("patients");

        //ref.setValue("Hello, World");

        patients.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot snapshot)
            {
                ArrayList<String> names = new ArrayList<>();
                for (DataSnapshot ds : snapshot.getChildren())
                {
                    String name = ds.child("name").getValue(String.class);
                    names.add(name);
                    Log.d(TAG, "the value is: " + name);
                }
                for (String name : names)
                {
                    TextView textView = findViewById(R.id.textViewDisplayPatient);
                    textView.setText(textView.getText().toString() + name + " , ");
                }
            }

            @Override
            public void onCancelled(DatabaseError error)
            {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}