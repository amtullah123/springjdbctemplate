package com.stackroute.domain;

import java.util.Date;

public class Movie {
    private int movie_id;
    private String movie_name;
    private int release_year;
    private int rating;

    public Movie() {
    }

    public Movie(int movie_id, String movie_name, int release_year, int rating) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.release_year = release_year;
        this.rating = rating;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", movie_name='" + movie_name + '\'' +
                ", release_year=" + release_year +
                ", rating=" + rating +
                '}';
    }
}