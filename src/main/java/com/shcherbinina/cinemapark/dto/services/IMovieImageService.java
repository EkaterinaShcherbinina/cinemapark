package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dto.entity.MovieImageDTO;

public interface IMovieImageService {
    MovieImageDTO getMovieImageDTOByImageId(int imageId);
}
