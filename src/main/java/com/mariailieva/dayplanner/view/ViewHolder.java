package com.mariailieva.dayplanner.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mariailieva.dayplanner.DetailActivity;
import com.mariailieva.dayplanner.R;
import com.mariailieva.dayplanner.model.Task;
import com.mariailieva.dayplanner.storage.FireBaseStorage;
import com.mariailieva.dayplanner.storage.TaskStorage;


public class ViewHolder extends RecyclerView.ViewHolder  {

    private TextView textViewTime;
    private TextView textViewName;
    private Context context;
    int rowNumber = 0;

    public ViewHolder(@NonNull View itemView){
        super(itemView);
        LinearLayout linearLayout=(LinearLayout) itemView;
        context = itemView.getContext();
        textViewTime = linearLayout.findViewById(R.id.textViewTime);
        textViewName = linearLayout.findViewById(R.id.textViewName);
        openDetailActivity();
        deleteOnLongClick();
    }

    private void deleteOnLongClick() {
        textViewName.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                FireBaseStorage.deleteTask(TaskStorage.getTask(rowNumber).getId());
                return false;
            }
        });
    }

    private void openDetailActivity() {
        textViewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("position",rowNumber);
                context.startActivity(intent);
            }
        });
    }

    public void setPosition(int position) {
        rowNumber=position;
        textViewTime.setText(TaskStorage.getTask(position).getTime());
        textViewName.setText(TaskStorage.getTask(position).getName());
    }
}

