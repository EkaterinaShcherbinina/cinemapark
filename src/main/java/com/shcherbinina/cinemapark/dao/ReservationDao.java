package com.shcherbinina.cinemapark.dao;

import com.shcherbinina.cinemapark.dao.entity.*;
import com.shcherbinina.cinemapark.dao.repository.MovieSessionRepository;
import com.shcherbinina.cinemapark.dao.repository.ReservationRepository;
import com.shcherbinina.cinemapark.dto.entity.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ReservationDao implements IReservationDao {
    @Autowired
    EntityManager entityManager;

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private MovieSessionRepository sessionDAO;

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
    public void addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void updateReservation(Reservation reservation) {
        addReservation(reservation);
    }

    @Override
    public void deleteReservation(int reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    @Override
    public Reservation getReservationById(int reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId);
        return reservation;
    }

    @Override
    public Reservation getReservation(ReservationDTO dto) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Reservation> q = cb.createQuery(Reservation.class);
        Root<Reservation> root = q.from(Reservation.class);
        Predicate sessionPredicate = cb.equal(root.get("movieSession").get("id"), dto.getSessionId());
        Predicate rowPredicate = cb.equal(root.get("rowId"), dto.getRowId());
        Predicate placePredicate = cb.equal(root.get("place"), dto.getPlace());
        q.where(sessionPredicate, rowPredicate, placePredicate);
        Reservation reservation = entityManager.createQuery(q).getSingleResult();

        return reservation;
    }

    @Override
    public List<Reservation> getAllByUserId(int userId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Reservation> q = cb.createQuery(Reservation.class);
        Root<Reservation> root = q.from(Reservation.class);
        Predicate userPredicate = cb.equal(root.get("user").get("id"), userId);
        q.where(userPredicate);
        List<Reservation> result = entityManager.createQuery(q).getResultList();
        return result;
    }
}
