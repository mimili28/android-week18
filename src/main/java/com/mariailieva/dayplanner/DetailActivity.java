package com.mariailieva.dayplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;
import com.mariailieva.dayplanner.model.Task;
import com.mariailieva.dayplanner.storage.FireBaseStorage;
import com.mariailieva.dayplanner.storage.TaskStorage;

import java.time.LocalTime;

public class DetailActivity extends AppCompatActivity {
    private EditText time;
    private EditText name;
    private EditText note;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        time=findViewById(R.id.editTextTime);
        name = findViewById(R.id.editTextName);
        note = findViewById(R.id.editTextNote);

        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);

        time.setText(TaskStorage.getTask(position).getTime());
        name.setText(TaskStorage.getTask(position).getName());
        note.setText(TaskStorage.getTask(position).getNote());
    }

    @Override
    protected void onPause(){
        super.onPause();
        TaskStorage.getTask(position).setTime(time.getText().toString());
        TaskStorage.getTask(position).setName(name.getText().toString());
        TaskStorage.getTask(position).setNote(note.getText().toString());
        FireBaseStorage.editTask(TaskStorage.getTask(position).getId(),position);
    }
}
