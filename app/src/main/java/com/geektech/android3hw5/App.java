package com.geektech.android3hw5;

import android.app.Application;

import androidx.room.Room;

import com.geektech.android3hw5.data.local.Database;
import com.geektech.android3hw5.data.local.RoomSource;
import com.geektech.android3hw5.data.remote.RetrofitSource;
import com.geektech.android3hw5.data.repository.LocalFilmRepo;
import com.geektech.android3hw5.data.repository.RemoteFilmRepo;

public class App extends Application {

    public static Database database;
    public static LocalFilmRepo localRepo;
    public static RemoteFilmRepo remoteRepo;

    @Override
    public void onCreate() {
        super.onCreate();
        createDatabase();
        setRepo();
    }

    private void setRepo() {
        remoteRepo = new RemoteFilmRepo(new RetrofitSource());
        localRepo = new LocalFilmRepo(new RoomSource());
    }

    private void createDatabase() {
        database = Room.databaseBuilder(this
                , Database.class
                , "database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

}
