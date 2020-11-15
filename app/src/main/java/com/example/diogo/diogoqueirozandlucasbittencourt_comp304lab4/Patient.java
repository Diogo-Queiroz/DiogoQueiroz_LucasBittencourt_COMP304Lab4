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

    @ColumnInfo(name = "name")
    private String name;

    public Patient(){}
    public Patient(int patientsId, String name)
    {
        this.patientsId = patientsId;
        this.name = name;
    }

    public int getPatientsId()
    {
        return patientsId;
    }
    public void setPatientsId(int patientsId)
    {
        this.patientsId = patientsId;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
}
