package com.example.academictracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Button addButton = (Button) findViewById(R.id.submitButton);
        EditText taskTitle = (EditText) findViewById(R.id.taskTitleInput);

        addButton.setOnClickListener(new View.OnClickListener() {
            TaskModel taskmodel;
            public void onClick(View v) {
                taskmodel = new TaskModel(taskTitle.getText().toString());
                //Toast.makeText(addTaskActivity.this, taskmodel.getTaskName(), Toast.LENGTH_SHORT).show();
                DataBaseHelper dbhelper = new DataBaseHelper(addTaskActivity.this);

                Log.d("Hello", taskmodel.getTaskName().toString());
                boolean success = dbhelper.addEntry(taskmodel);

                if(success == true){
                    Toast.makeText(addTaskActivity.this, "Success", Toast.LENGTH_SHORT);
                }
                else Toast.makeText(addTaskActivity.this, "Failed", Toast.LENGTH_SHORT);

                finish();
            }
        });
    }
}