package com.shcherbinina.cinemapark.dao.repository;

import com.shcherbinina.cinemapark.dao.entity.MovieImage;

import java.sql.Blob;

public interface IMovieImageRepository {
    MovieImage getMovieImageById(int imageId);
    void updateMovieImage(int id, Blob image);
}
