package com.shcherbinina.cinemapark.dao.repository;

import com.shcherbinina.cinemapark.dao.MovieImageDAO;
import com.shcherbinina.cinemapark.dao.entity.MovieImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieImageRepository implements IMovieImageRepository {
    @Autowired
    MovieImageDAO imageDAO;

    @Override
    public MovieImage getMovieImageById(int imageId) {
        return imageDAO.findById(imageId).get();
    }
}
