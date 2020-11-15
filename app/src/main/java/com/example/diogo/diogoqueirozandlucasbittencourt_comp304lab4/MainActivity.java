package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private StudentViewModel studentViewModel;
    private Button btnInsertStudent;
    private EditText editTextStudentId, editTextStudentName,
            editTextCourseCode, editTextCourseName;
    private TextView textViewDisplay, textViewCourses;
    Student student;
    Course course;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        textViewDisplay = findViewById(R.id.textViewDisplay);
        textViewCourses = findViewById(R.id.textViewCourses);

        studentViewModel = new ViewModelProvider(this).get(StudentViewModel.class);
        //
        student = new Student();
        course = new Course();
        //
        //if the LiveData already has data that will be delivered
        // to the observer
        studentViewModel.getAllStudents().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(@Nullable List<Student> result) {
                String output="";
                for(Student person : result) {
                    output+= person.getName() +"\n";
                }
                textViewDisplay.setText(output);
            }
        });

    }
    public void insertStudent(View view)
    {
        //inserting a student
        editTextStudentId = findViewById(R.id.editTextStudentId);
        student.setStudentId(Integer.parseInt(editTextStudentId.getText().toString()));
        editTextStudentName = findViewById(R.id.editTextStudentName);
        student.setName(editTextStudentName.getText().toString());
        studentViewModel.insertStudent(student);

    }
    //
    public void insertCourse(View view)
    {
        //inserting a student
        editTextCourseCode = findViewById(R.id.editTextCourseCode);
        course.setCourseCode(editTextCourseCode.getText().toString());
        editTextCourseName = findViewById(R.id.editTextCourseName);
        course.setCourseName(editTextCourseName.getText().toString());
        studentViewModel.insertCourse(course);

    }
    //
    public void getList(View view)
    {

        studentViewModel.getAllStudents().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(@Nullable List<Student> result) {
                String  output="";

                for(Student student : result) {
                    output+= student.getName() +"\n";
                }
                textViewDisplay.setText(output);
            }
        });
        //
        studentViewModel.getAllCourses().observe(this, new Observer<List<Course>>() {
            @Override
            public void onChanged(@Nullable List<Course> result) {
                String  output="";

                for(Course course : result) {
                    output+= course.getCourseName() +"\n";
                }
                textViewCourses.setText(output);
            }
        });



    }
}