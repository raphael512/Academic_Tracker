package com.example.academictracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String taskTable = "taskTable";
    public static final String ID = "ID";
    public static final String TASK_TITLE = "taskTitle";

    public DataBaseHelper(Context context) {
        super(context, "task.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + taskTable + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TASK_TITLE + " TEXT)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addEntry(TaskModel taskModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TASK_TITLE, taskModel.getTaskName().toString());

        long insert = db.insert("taskTable", null, cv);

        if (insert == -1) {
            return false;
        } else return true;
    }

    public List<String> getList() {
        List<String> getList = new ArrayList();

        String query = "SELECT * FROM taskTable";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                String taskTitle = cursor.getString(1);
                getList.add(taskTitle);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return getList;
    }
}
