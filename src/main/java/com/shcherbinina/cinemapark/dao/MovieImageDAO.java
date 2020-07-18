package com.shcherbinina.cinemapark.dao;

import com.shcherbinina.cinemapark.dao.entity.MovieImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieImageDAO extends CrudRepository<MovieImage, Integer> {

}
