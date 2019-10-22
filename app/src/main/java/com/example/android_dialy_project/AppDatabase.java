package com.example.android_dialy_project;

import androidx.room.Database;
import androidx.room.RoomDatabase;

    @Database(entities = {Dialy.class}, version = 1, exportSchema = false)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract DialyDao dialyDao();
    }

