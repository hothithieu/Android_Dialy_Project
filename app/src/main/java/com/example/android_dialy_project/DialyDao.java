package com.example.android_dialy_project;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DialyDao {

    @Query("SELECT * FROM Dialy")
    List<Dialy> getAll();

    @Insert
    void insert(Dialy daily);

    @Delete
    void delete(Dialy daily);
}
