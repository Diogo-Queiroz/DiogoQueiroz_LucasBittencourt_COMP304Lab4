package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {
        Patient.class, Nurse.class, Test.class
}, version = 1, exportSchema = false)
public abstract class TestRoomDatabase
    extends RoomDatabase
{
    public abstract PatientsDao patientsDao();
    public abstract NurseDao nurseDao();
    public abstract TestDao testDao();

    private static volatile TestRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static TestRoomDatabase getDatabase(final Context context)
    {
        if (INSTANCE == null)
        {
            synchronized (TestRoomDatabase.class)
            {
                if (INSTANCE == null)
                {
                    INSTANCE = Room.databaseBuilder(
                                context.getApplicationContext(),
                                TestRoomDatabase.class,
                                "tests")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
