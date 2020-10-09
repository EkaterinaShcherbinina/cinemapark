package com.shcherbinina.cinemapark.dao.repository;

import com.shcherbinina.cinemapark.dao.entity.MovieSession;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieSessionRepository extends CrudRepository<MovieSession, Integer> {
    @Query(nativeQuery = true, value = "select movieId from movieSession where dateSession = :date group by movieId")
    List<Integer> getNonRepeatingMovieIdForSessionsByDate(@Param("date")java.sql.Date date);
}
