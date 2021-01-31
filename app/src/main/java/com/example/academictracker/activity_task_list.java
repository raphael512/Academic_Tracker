package com.example.academictracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class activity_task_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        DataBaseHelper db = new DataBaseHelper(activity_task_list.this);
        List<String> list = db.getList();

        //Toast.makeText(activity_task_list.this, list.toString(), Toast.LENGTH_SHORT);
    }
}