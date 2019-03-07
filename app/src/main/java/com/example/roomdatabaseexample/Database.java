package com.example.roomdatabaseexample;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@android.arch.persistence.room.Database(entities = {Model.class},version = 1,exportSchema = false)
public abstract class Database extends RoomDatabase {

    public abstract MyDao getDao();

    private static volatile Database obj;

    static Database getDatabase(final Context context) {
        if (obj == null) {
            synchronized (Database.class) {
                if (obj== null) {
                    obj= Room.databaseBuilder(context.getApplicationContext(),
                            Database.class, "DATABASE")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return obj;

    }
}
