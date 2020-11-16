package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "tests",
        foreignKeys = {
            @ForeignKey(entity =  Patient.class, parentColumns = "patientsId", childColumns = "patientsId"),
            @ForeignKey(entity =  Nurse.class, parentColumns = "nurseId", childColumns = "nurseId")
        })
public class Test
{
    @PrimaryKey(autoGenerate = true)
    private int testId;

    @NonNull
    private int patientsId;

    @NonNull
    private int nurseId;

    @ColumnInfo(name =  "BPL")
    private String BPL;

    @ColumnInfo(name =  "BPH")
    private String BPH;

    @ColumnInfo(name =  "temperature")
    private String temperature;

    @ColumnInfo(name =  "cholesterol")
    private String cholesterol;

    public Test(int patientsId, int nurseId, int testId,
                String BPL, String BPH, String temperature, String cholesterol)
    {
        this.patientsId = patientsId;
        this.nurseId = nurseId;
        this.testId = testId;
        this.BPH = BPH;
        this.BPL = BPL;
        this.temperature = temperature;
        this.cholesterol = cholesterol;
    }

    public int getPatientsId()
    {
        return patientsId;
    }
    public int getNurseId()
    {
        return nurseId;
    }
    public int getTestId()
    {
        return testId;
    }
    public void setTestId(int testId)
    {
        this.testId = testId;
    }
    public String getBPL()
    {
        return BPL;
    }
    public void setBPL(String BPL)
    {
        this.BPL = BPL;
    }
    public String getBPH()
    {
        return BPH;
    }
    public void setBPH(String BPH)
    {
        this.BPH = BPH;
    }
    public String getTemperature()
    {
        return temperature;
    }
    public void setTemperature(String temperature)
    {
        this.temperature = temperature;
    }
    public String getCholesterol()
    {
        return cholesterol;
    }
    public void setCholesterol(String cholesterol)
    {
        this.cholesterol = cholesterol;
    }
}
