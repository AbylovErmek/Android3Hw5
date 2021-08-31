package com.geektech.android3hw5.data.source;

import com.geektech.android3hw5.data.model.Film;

import java.util.List;

public interface LocalFilmSource {

    List<Film> getAllFilms();

    void insert(Film film);

    void delete(Film film);

    Film getFilm(String filmId);

}
