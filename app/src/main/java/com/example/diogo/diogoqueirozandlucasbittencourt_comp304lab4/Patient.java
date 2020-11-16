package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Patient
{
    @PrimaryKey
    @ColumnInfo(name = "patientsId")
    private int patientsId;

    @ColumnInfo(name = "firstName")
    private String firstName;

    @ColumnInfo(name = "lastName")
    private String lastName;

    public Patient(){}
    public Patient(int patientsId, String firstName, String lastName)
    {
        this.patientsId = patientsId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getPatientsId()
    {
        return patientsId;
    }
    public void setPatientsId(int patientsId)
    {
        this.patientsId = patientsId;
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
}
