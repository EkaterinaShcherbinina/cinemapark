package com.shcherbinina.cinemapark.dao;

import com.shcherbinina.cinemapark.dao.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationDAO extends CrudRepository<Reservation, Integer> {
    Reservation findById(int id);
}
