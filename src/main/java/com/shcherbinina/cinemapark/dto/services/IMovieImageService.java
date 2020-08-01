package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dto.entity.MovieImageDTO;

import java.sql.Blob;

public interface IMovieImageService {
    MovieImageDTO getMovieImageDTOByImageId(int imageId);
    void updateMovieImage(int id, Blob image);
}
