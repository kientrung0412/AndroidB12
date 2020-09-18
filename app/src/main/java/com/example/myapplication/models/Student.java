package com.example.myapplication.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Student implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo
    private String name;
    @ColumnInfo
    private Float score;
    @ColumnInfo
    private String subject;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getScore() {
        return score;
    }

    public String getSubject() {
        return subject;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
