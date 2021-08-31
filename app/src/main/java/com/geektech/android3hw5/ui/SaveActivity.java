package com.geektech.android3hw5.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.geektech.android3hw5.App;
import com.geektech.android3hw5.R;
import com.geektech.android3hw5.data.model.Film;
import com.geektech.android3hw5.databinding.ActivitySaveBinding;
import com.geektech.android3hw5.utils.Keys;
import com.geektech.android3hw5.utils.MultipurposeToast;

import java.util.List;

public class SaveActivity extends AppCompatActivity {

    private ActivitySaveBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySaveBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initViews();
    }

    private void initViews() {
        RecyclerView recyclerView = binding.recycler;
        FilmAdapter adapter = new FilmAdapter(getString(R.string.Saved), getFilms(), this::onItemClick, this::onFavClick);
        recyclerView.setAdapter(adapter);
    }

    private void onItemClick(String id) {
        Intent intent = new Intent(SaveActivity.this, FormActivity.class);
        intent.putExtra(Keys.getFilmKey(), id);
        intent.putExtra(Keys.getTag(), getString(R.string.saved));
        startActivity(intent);
    }

    private void onFavClick(Film film) {
        App.localRepo.delete(film);
        MultipurposeToast.show(this, getString(R.string.deleted));
    }

    private List<Film> getFilms() {
        return App.localRepo.getAllFilms();
    }

}