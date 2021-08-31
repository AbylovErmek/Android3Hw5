package com.geektech.android3hw5.data.local;

import androidx.room.RoomDatabase;

import com.geektech.android3hw5.data.model.SavedFilm;

@androidx.room.Database(entities = {SavedFilm.class}, version = 1)
public abstract class Database extends RoomDatabase {

    public abstract FilmDao filmDao();

}
