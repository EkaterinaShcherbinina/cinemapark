package com.shcherbinina.cinemapark.dao;

import com.shcherbinina.cinemapark.dao.entity.RowCinemaHall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RowDAO extends CrudRepository<RowCinemaHall, Integer> {
}