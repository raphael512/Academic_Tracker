package com.example.academictracker;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.List;

public class activity_task_list extends AppCompatActivity {
    int x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        DataBaseHelper db = new DataBaseHelper(activity_task_list.this);
        List<String> list = db.getList();
        CheckBox[] checkBox = new CheckBox[list.size()];
        LinearLayout lnrLayout = (LinearLayout) findViewById(R.id.lnrLayout);

        for(x = 0; list.isEmpty() == false; x++){
            if(list.size() == x){
                break;
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) LinearLayout.LayoutParams.WRAP_CONTENT, (int) LinearLayout.LayoutParams.WRAP_CONTENT);
            params.topMargin = 50;
            params.leftMargin = 50;
            checkBox[x] = new CheckBox(this);
            checkBox[x].setText(list.get(x));
            checkBox[x].setTextSize((float) 18);
            checkBox[x].setLayoutParams(params);
            checkBox[x].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    lnrLayout.removeView(buttonView);
                }
            });

            lnrLayout.addView(checkBox[x]);
        }
    }
}