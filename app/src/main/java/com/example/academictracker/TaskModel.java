package com.example.academictracker;

public class TaskModel {
    String taskName;

    public TaskModel(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String toString() {
        return "TaskModel{" +
                "taskName='" + taskName + '\'' +
                '}';
    }

    public String getTaskName() {
        return taskName;
    }

    //COMMENT TASK MODELQFQFQFQGQGQEG23412412
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
