package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "test",
        primaryKeys = { "patientsId", "nurseId" },
        foreignKeys = {
            @ForeignKey(entity =  Patient.class, parentColumns = "patientsId", childColumns = "patientsId"),
            @ForeignKey(entity =  Nurse.class, parentColumns = "nurseId", childColumns = "nurseId")
        })
public class Test
{
    private int patientsId;
    @NonNull
    private int nurseId;

    public Test(int patientsId, int nurseId)
    {
        this.patientsId = patientsId;
        this.nurseId = nurseId;
    }

    public int getPatientsId()
    {
        return patientsId;
    }
    public int getNurseId()
    {
        return nurseId;
    }
}
