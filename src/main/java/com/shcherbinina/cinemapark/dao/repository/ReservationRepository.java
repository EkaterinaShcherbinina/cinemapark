package com.shcherbinina.cinemapark.dao.repository;

import com.shcherbinina.cinemapark.dao.ReservationDAO;
import com.shcherbinina.cinemapark.dao.entity.*;
import com.shcherbinina.cinemapark.dto.entity.ReservationDTO;
import com.shcherbinina.cinemapark.dto.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ReservationRepository implements IReservationRepository {
    @Autowired
    EntityManager entityManager;

    @Autowired
    private ReservationDAO reservationDAO;

    @Override
    public List<Reservation> getReservationsBySessionId(int sessionId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Reservation> q = cb.createQuery(Reservation.class);
        Root<Reservation> root = q.from(Reservation.class);
        Predicate sessionPredicate = cb.equal(root.get("movieSession").get("id"), sessionId);
        q.where(sessionPredicate);
        List<Reservation> reservations = entityManager.createQuery(q).getResultList();

        return reservations;
    }

    @Override
    @Transactional
    public void addReservation(Reservation reservation) {
        reservationDAO.save(reservation);
    }

    @Override
    public void updateReservation(Reservation reservation) {
        addReservation(reservation);
    }

    @Override
    public void deleteReservation(int reservationId) {
        reservationDAO.deleteById(reservationId);
    }

    @Override
    public Reservation getReservationById(int reservationId) {
        Reservation reservation = reservationDAO.findById(reservationId);
        return reservation;
    }
}
