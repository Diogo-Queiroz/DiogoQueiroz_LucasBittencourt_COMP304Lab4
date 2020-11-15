package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Nurse
{
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "nurseId")
    private int nurseId;

    @ColumnInfo(name = "name")
    private String name;

    public Nurse(){}
    public Nurse(int nurseId, String name)
    {
        this.nurseId = nurseId;
        this.name = name;
    }

    public int getNurseId()
    {
        return nurseId;
    }
    public void setNurseId(int nurseId)
    {
        this.nurseId = nurseId;
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
