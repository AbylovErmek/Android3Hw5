package com.geektech.android3hw5.data.source;

import com.geektech.android3hw5.data.model.Film;
import com.geektech.android3hw5.data.remote.RetrofitSource;

import java.util.List;

public interface RemoteFilmSource {

    void getFilms(RetrofitSource.FilmCallback<List<Film>> callback);

    void getFilm(String id, RetrofitSource.FilmCallback<Film> callback);

}
