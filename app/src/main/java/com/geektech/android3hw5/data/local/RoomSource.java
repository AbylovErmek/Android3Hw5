package com.geektech.android3hw5.data.local;

import com.geektech.android3hw5.App;
import com.geektech.android3hw5.data.model.Film;
import com.geektech.android3hw5.data.model.SavedFilm;
import com.geektech.android3hw5.data.source.LocalFilmSource;

import java.util.ArrayList;
import java.util.List;

public class RoomSource implements LocalFilmSource {

    @Override
    public List<Film> getAllFilms() {
        if (App.database.filmDao().getAllFilms() != null)
            return mapToFilmList(App.database.filmDao().getAllFilms());
        return new ArrayList<>();
    }

    @Override
    public void insert(Film film) {
        App.database.filmDao().insert(new SavedFilm(film));
    }

    @Override
    public void delete(Film film) {
        App.database.filmDao().delete(film.getFilmId());
    }

    @Override
    public Film getFilm(String filmId) {
        SavedFilm savedFilm = App.database.filmDao().getFilm(filmId);
        return savedFilm.getFilm();
    }

    private List<Film> mapToFilmList(List<SavedFilm> savedFilms) {
        List<Film> films = new ArrayList<>();
        for (SavedFilm film : savedFilms) {
            films.add(film.getFilm());
        }
        return films;
    }
}
