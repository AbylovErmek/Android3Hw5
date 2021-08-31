package com.geektech.android3hw5.data.remote;

import android.util.Log;

import androidx.annotation.NonNull;

import com.geektech.android3hw5.data.model.Film;
import com.geektech.android3hw5.data.model.LoadedFilm;
import com.geektech.android3hw5.data.source.RemoteFilmSource;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitSource implements RemoteFilmSource {

    @Override
    public void getFilms(FilmCallback<List<Film>> callback) {
        RetrofitBuilder.getInstance().getFilms().enqueue(new Callback<List<LoadedFilm>>() {
            @Override
            public void onResponse(@NonNull Call<List<LoadedFilm>> call, @NonNull Response<List<LoadedFilm>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.success(mapToFilmList(response.body()));
                } else callback.onFailure("Request error");
            }

            @Override
            public void onFailure(@NonNull Call<List<LoadedFilm>> call, @NonNull Throwable t) {
                callback.onFailure(t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void getFilm(String filmId, FilmCallback<Film> callback) {
        RetrofitBuilder.getInstance().getFilm(filmId).enqueue(new Callback<LoadedFilm>() {
            @Override
            public void onResponse(@NonNull Call<LoadedFilm> call, @NonNull Response<LoadedFilm> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.success(mapToFilm(response.body()));
                    Log.d("TAG", "onResponse: " + response.body().getTitle());
                } else callback.onFailure("Request error");
            }

            @Override
            public void onFailure(@NonNull Call<LoadedFilm> call, @NonNull Throwable t) {
                callback.onFailure(t.getLocalizedMessage());
            }
        });
    }

    public interface FilmCallback<ContentData> {
        void success(ContentData data);

        default void onFailure(String errorMsg) {
            Log.e("TAG", "onFailure: " + errorMsg);
        }
    }

    private List<Film> mapToFilmList(List<LoadedFilm> loadedFilms) {
        List<Film> list = new ArrayList<>();
        for (LoadedFilm loaded : loadedFilms) {
            list.add(new Film(loaded.getId()
                    , loaded.getTitle()
                    , loaded.getOriginalTitle()
                    , loaded.getDescription()
                    , loaded.getProducer()
                    , loaded.getReleaseDate()));
        }
        return list;
    }

    private Film mapToFilm(LoadedFilm loadedFilm) {
        return new Film(loadedFilm.getId()
                , loadedFilm.getTitle()
                , loadedFilm.getOriginalTitle()
                , loadedFilm.getDescription()
                , loadedFilm.getProducer()
                , loadedFilm.getReleaseDate());
    }

}
