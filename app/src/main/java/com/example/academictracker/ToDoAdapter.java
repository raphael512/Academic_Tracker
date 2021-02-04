package com.example.academictracker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

//import com.example.academictracker.CheckBox;
import com.example.academictracker.*;

import java.util.List;


public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder>{

    private List<TaskModel> task_list;

    DataBaseHelper db;
    MainActivity activity;

    public ToDoAdapter(DataBaseHelper db, MainActivity activity) {
        this.db = db;
        this.activity = activity;
    }

//123
    @NonNull
    @Override
    public ToDoAdapter.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.checkbox, viewGroup, false);
        return new ViewHolder(itemView);
    }

    /**
     *
     * Kukuha ng data sa List
     */
    @Override
    public void onBindViewHolder(@NonNull ToDoAdapter.ViewHolder viewHolder, int i) {

        /**
         * position sa data set?????
         *
         */
        final TaskModel item = task_list.get(position);

        viewHolder.checkBox_venti.setText(item.getTaskName());

        /**
         * int getStatus
         */
//        viewHolder.checkBox_venti.setChecked(toBoolean(item.getStatus()));


        viewHolder.checkBox_venti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                }

                else {

                }
            }
        });

    }



    private boolean toBoolean(int n) {
        return n != 0;
    }


    @Override
    public int getItemCount() {
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        CheckBox checkBox_venti;

        public ViewHolder(@NonNull View view) {
            super(view);
            checkBox_venti = (CheckBox) view.findViewById(R.id.checkBox_checkBox);

        }
    }
}
