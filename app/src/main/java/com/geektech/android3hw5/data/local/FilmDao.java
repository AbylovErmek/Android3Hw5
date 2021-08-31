package com.geektech.android3hw5.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.geektech.android3hw5.data.model.SavedFilm;

import java.util.List;

@Dao
public interface FilmDao {

    @Query("select * from films")
    List<SavedFilm> getAllFilms();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SavedFilm film);

    @Query("delete from films where filmId = :filmId")
    void delete(String filmId);

    @Query("select * from films where filmId = :filmId")
    SavedFilm getFilm(String filmId);

}
