package com.shcherbinina.cinemapark.dto.services;

import com.shcherbinina.cinemapark.dao.repository.MovieImageRepository;
import com.shcherbinina.cinemapark.dto.DTOConverter;
import com.shcherbinina.cinemapark.dto.entity.MovieImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Blob;

@Service
public class MovieImageService implements IMovieImageService{
    @Autowired
    private MovieImageRepository imageRepository;
    @Autowired
    DTOConverter dtoConverter;

    @Override
    public MovieImageDTO getMovieImageDTOByImageId(int imageId) {
        return dtoConverter.convertToMovieImageDTO(imageRepository.getMovieImageById(imageId));
    }

    @Override
    public void updateMovieImage(int id, Blob image) {
        imageRepository.updateMovieImage(id, image);
    }
}
