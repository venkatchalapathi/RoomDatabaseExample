package com.example.roomdatabaseexample;

import android.app.Application;
import android.app.ListActivity;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    MyRepository repository;
    public MyDao dao;
    public LiveData<List<Model>> listLiveData;

    public MyViewModel(@NonNull Application application) {
        super(application);
        repository = new MyRepository(application);
        dao = repository.getDao();
        listLiveData = repository.getListLiveData();
    }

    public MyDao getDao() {
        return dao;
    }

    public LiveData<List<Model>> getListLiveData() {
        return listLiveData;
    }

    public void insert(Model model){
        repository.insert(model);
    }

}
