package com.shcherbinina.cinemapark.dao;

import com.shcherbinina.cinemapark.dao.entity.RowCinemaHall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RowDAO extends CrudRepository<RowCinemaHall, Integer> {

   /* @Query(value = "SELECT new com.shcherbinina.cinemapark.services.entity.PlaceReservationDTO(c.id, c.rowsAmount, c.rows) from CinemaHall c where c.id = :hallId")
    List<PlaceReservationDTO> findAllPlacesByHall(@Param("hallId")int hallId);*/
}