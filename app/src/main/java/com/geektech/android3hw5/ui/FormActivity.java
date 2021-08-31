package com.geektech.android3hw5.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.geektech.android3hw5.App;
import com.geektech.android3hw5.R;
import com.geektech.android3hw5.data.model.Film;
import com.geektech.android3hw5.databinding.ActivityFormBinding;
import com.geektech.android3hw5.utils.Keys;

public class FormActivity extends AppCompatActivity {

    private ActivityFormBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        checkIntent();
    }

    private void checkIntent() {
        if (getIntent() != null) {
            if (getIntent().getStringExtra(Keys.getTag()).equals(getString(R.string.Loaded)))
                getFilmAndSet(getIntent().getStringExtra(Keys.getFilmKey()));
            else
                loadFilmAndSet(getIntent().getStringExtra(Keys.getFilmKey()));
        }
    }

    private void loadFilmAndSet(String id) {
        App.remoteRepo.getFilm(id, this::setData);
    }

    private void getFilmAndSet(String id) {
        setData(App.localRepo.getFilm(id));
    }

    private void setData(Film film) {
        binding.progressbar.setVisibility(View.GONE);
        binding.title.setText(film.getTitle());
        binding.originalTitle.setText(film.getOriginalTitle());
        binding.producer.setText(film.getProducer());
        binding.releaseDate.setText(film.getReleaseDate());
        binding.description.setText(film.getDescription());
    }

}