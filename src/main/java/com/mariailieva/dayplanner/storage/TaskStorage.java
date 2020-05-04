package com.mariailieva.dayplanner.storage;

import com.mariailieva.dayplanner.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskStorage {

    public static List<Task> list = new ArrayList<>();

    public static Task getTask(int index){
        return list.get(index);
    }

    public static List<Task> getList(){
        return list;
    }
}
