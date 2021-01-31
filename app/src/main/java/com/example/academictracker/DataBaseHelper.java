package com.example.academictracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String taskTable = "taskTable";
    public static final String ID = "ID";
    public static final String TASK_TITLE = "taskTitle";

    public DataBaseHelper(Context context) {
        super(context, "task.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE "+ taskTable + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TASK_TITLE + " TEXT)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addEntry(TaskModel taskModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TASK_TITLE, taskModel.getTaskName().toString());

        long insert = db.insert("taskTable", null, cv);

        if(insert == -1){
            return false;
        }
        else return true;
    }
}
