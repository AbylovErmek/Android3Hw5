package com.geektech.android3hw5.data.repository;

import com.geektech.android3hw5.data.model.Film;
import com.geektech.android3hw5.data.remote.RetrofitSource;
import com.geektech.android3hw5.data.source.RemoteFilmSource;

import java.util.List;

public class RemoteFilmRepo {

    private final RemoteFilmSource source;

    public RemoteFilmRepo(RemoteFilmSource source) {
        this.source = source;
    }

    public void getFilms(RetrofitSource.FilmCallback<List<Film>> callback) {
        source.getFilms(callback);
    }

    public void getFilm(String id, RetrofitSource.FilmCallback<Film> callback) {
        source.getFilm(id, callback);
    }

}
