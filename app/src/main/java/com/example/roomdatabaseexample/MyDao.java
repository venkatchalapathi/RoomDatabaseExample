package com.example.roomdatabaseexample;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MyDao {


    @Query("Select * from Student")
    public LiveData<List<Model>> getAllData();

    @Insert
    public void insert(Model model);

    @Delete
    public void delete(Model model);
}
