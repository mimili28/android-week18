package com.mariailieva.dayplanner.storage;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.mariailieva.dayplanner.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FireBaseStorage {

    private final static String tasks = "tasks";
    private static FirebaseFirestore db = FirebaseFirestore.getInstance();
    public static RecyclerView.Adapter adapter;

    static {
        startTaskListener();
    }

    private static void startTaskListener() {
        db.collection(tasks).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot values, @Nullable FirebaseFirestoreException e) {
                TaskStorage.list.clear();
                for (DocumentSnapshot snap: values.getDocuments()){
                    TaskStorage.list.add(new Task(snap.getId(), snap.get("time").toString(),snap.get("name").toString(),
                            snap.get("note").toString()));
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    public static void addNewTask() {
        DocumentReference docRef = db.collection(tasks).document();
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","new task");
        map.put("time","time");
        map.put("note","blah blah");
        docRef.set(map);
    }

    public static void editTask(String id, int position) {
        DocumentReference docRef = db.collection(tasks).document(id);
        Map<String, Object> map = new HashMap<>();
        map.put("name",TaskStorage.getTask(position).getName());
        map.put("time",TaskStorage.getTask(position).getTime());
        map.put("note", TaskStorage.getTask(position).getNote());
        docRef.set(map);
    }

    public static void deleteTask(String id) {
        DocumentReference docRef = db.collection(tasks).document(id);
        docRef.delete();
    }
}
