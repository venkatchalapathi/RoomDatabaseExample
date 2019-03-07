package com.example.roomdatabaseexample;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.lang.ref.SoftReference;

@Entity (tableName = "Student")
public class Model {

    @PrimaryKey
    @NonNull
    private String id;
    private String name;
    private String branch;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
