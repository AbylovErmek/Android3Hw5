package com.geektech.android3hw5.data.model;

public class Film {

    private String filmId;
    private String title;
    private String originalTitle;
    private String description;
    private String producer;
    private String releaseDate;

    public Film(String filmId, String title, String originalTitle, String description, String producer, String releaseDate) {
        this.filmId = filmId;
        this.title = title;
        this.originalTitle = originalTitle;
        this.description = description;
        this.producer = producer;
        this.releaseDate = releaseDate;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
