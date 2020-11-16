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

    @ColumnInfo(name = "firstName")
    private String firstName;

    @ColumnInfo(name = "lastName")
    private String lastName;

    public Nurse(){}
    public Nurse(int nurseId, String firstName, String lastName)
    {
        this.nurseId = nurseId;
        this.firstName = firstName;
        this.lastName = lastName;
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
}
