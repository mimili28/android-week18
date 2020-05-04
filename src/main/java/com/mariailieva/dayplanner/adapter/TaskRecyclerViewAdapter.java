package com.mariailieva.dayplanner.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mariailieva.dayplanner.R;
import com.mariailieva.dayplanner.storage.FireBaseStorage;
import com.mariailieva.dayplanner.storage.TaskStorage;
import com.mariailieva.dayplanner.view.ViewHolder;

public class TaskRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

   // private FireBaseStorage fireBaseStorage;
    private TaskStorage taskStorage;

//    public TaskRecyclerViewAdapter(FireBaseStorage fireBaseStorage) {
//        this.fireBaseStorage = fireBaseStorage;
//    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.
                from(parent.getContext()).inflate(R.layout.taskrow, parent, false);
        return new ViewHolder(linearLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
        holder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return taskStorage.getList().size();
    }

}