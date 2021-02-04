package com.example.academictracker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

//import com.example.academictracker.CheckBox;
import com.example.academictracker.*;


public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder>{
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
