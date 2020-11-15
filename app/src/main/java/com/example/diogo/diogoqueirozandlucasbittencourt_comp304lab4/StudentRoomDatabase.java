package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {
        Student.class,
        Course.class,
        StudentCourse.class},
        version = 1, exportSchema = false)
public abstract class StudentRoomDatabase
    extends RoomDatabase
{
    //references to Dao objects
    public abstract StudentDao studentDao();
    public abstract CourseDao courseDao();
    public abstract StudentCourseDao studentCourseDao();
    //
    private static volatile StudentRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    // use this to run database operations
    // asynchronously on a background thread.
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    //
    //create and initialize the database instance
    static StudentRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (StudentRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            StudentRoomDatabase.class, "student_course_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
