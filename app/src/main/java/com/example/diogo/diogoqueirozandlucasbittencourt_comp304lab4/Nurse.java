package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Nurse
{
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "nurseId")
    private int nurseId;

    @ColumnInfo(name = "firstName")
    private String firstName;

    @ColumnInfo(name = "lastName")
    private String lastName;

    @ColumnInfo(name = "department")
    private String department;

    @ColumnInfo(name = "password")
    private String password;

    public Nurse(){}
    public Nurse(int nurseId, String firstName, String lastName,
                 String department, String password)
    {
        this.nurseId    = nurseId;
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.department = department;
        this.password   = password;
    }

    public int getNurseId()
    {
        return nurseId;
    }
    public void setNurseId(int nurseId)
    {
        this.nurseId = nurseId;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getDepartment()
    {
        return department;
    }
    public void setDepartment(String department)
    {
        this.department = department;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
}
