package com.shcherbinina.cinemapark.dao.repository;

import com.shcherbinina.cinemapark.dao.entity.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
    Movie findByName(String name);
    Movie findBySecondaryKey(String id);
    Movie findById(int id);

    @Query(nativeQuery = true, value = "select * from movie where premiereDate > :date")
    List<Movie> getMoviesMoreThanDate(@Param("date")java.sql.Date date);
}
