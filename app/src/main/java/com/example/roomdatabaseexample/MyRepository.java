package com.example.roomdatabaseexample;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class MyRepository {

    public MyDao dao;
    public LiveData<List<Model>> listLiveData;

    public MyRepository(Application application) {
        Database database = Database.getDatabase(application);
        dao = database.getDao();
        listLiveData = dao.getAllData();
    }

    public MyDao getDao() {
        return dao;
    }

    public LiveData<List<Model>> getListLiveData() {
        return listLiveData;
    }

    public LiveData<List<Model>> getmAllMeals() {
        return listLiveData;
    }

    void insert(Model word) {
        new insertAsyncTask(dao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Model, Void, Void> {

        private MyDao mAsyncTaskDao;

        insertAsyncTask(MyDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Model... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}