package com.shcherbinina.cinemapark.dao.repository;

import com.shcherbinina.cinemapark.dao.entity.MovieImage;

public interface IMovieImageRepository {
    MovieImage getMovieImageById(int imageId);
}
