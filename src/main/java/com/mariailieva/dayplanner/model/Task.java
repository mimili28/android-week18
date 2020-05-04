package com.mariailieva.dayplanner.model;

import java.time.LocalTime;

public class Task {

    private String id;
    private String time;
    private String name;
    private String note;

    public Task(String id, String time, String name, String note) {
        this.id = id;
        this.time = time;
        this.name = name;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
