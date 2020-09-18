package com.example.myapplication.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.models.Student;

import java.util.List;

@Dao
public interface AppDao {

    @Insert
    void insert(Student... students);

    @Update
    void update(Student... students);

    @Delete
    void delete(Student... students);

    @Query("SELECT * FROM   student")
    List<Student> get();
}
