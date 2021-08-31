package com.geektech.android3hw5.data.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "films")
public class SavedFilm {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @Embedded
    private Film film;

    public SavedFilm(Film film) {
        this.film = film;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
