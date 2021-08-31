package com.geektech.android3hw5.data.repository;

import com.geektech.android3hw5.data.model.Film;
import com.geektech.android3hw5.data.source.LocalFilmSource;

import java.util.List;

public class LocalFilmRepo {

    private final LocalFilmSource source;

    public LocalFilmRepo(LocalFilmSource source) {
        this.source = source;
    }

    public List<Film> getAllFilms() {
        return source.getAllFilms();
    }

    public void insert(Film film) {
        source.insert(film);
    }

    public void delete(Film film) {
        source.delete(film);
    }

    public Film getFilm(String filmId){
        return source.getFilm(filmId);
    }

}
