package com.shcherbinina.cinemapark.dao;

import com.shcherbinina.cinemapark.dao.entity.Reservation;
import com.shcherbinina.cinemapark.dao.repository.ReservationRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationDAO extends CrudRepository<Reservation, Integer> {
    Reservation findById(int id);
}
