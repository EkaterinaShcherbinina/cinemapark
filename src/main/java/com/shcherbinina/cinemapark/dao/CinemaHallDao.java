package com.shcherbinina.cinemapark.dao;

import com.shcherbinina.cinemapark.dao.entity.CinemaHall;
import com.shcherbinina.cinemapark.dao.repository.CinemaHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CinemaHallDao implements ICinemaHallDao {
    @Autowired
    CinemaHallRepository cinemaHallRepository;
    @Autowired
    EntityManager entityManager;

    @Override
    public CinemaHall getCinemaHallById(int hallId) {
        return cinemaHallRepository.findById(hallId);
    }

    @Override
    public CinemaHall getCinemaHallByName(String name) {
        return cinemaHallRepository.findByHallName(name);
    }

    @Override
    public List<CinemaHall> getAllCinemaHalls() {
        List<CinemaHall> list = new ArrayList<>();
        cinemaHallRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public void addCinemaHall(CinemaHall cinemaHall) {
        cinemaHallRepository.save(cinemaHall);
    }

    @Override
    public void updateCinemaHall(CinemaHall cinemaHall) {
        addCinemaHall(cinemaHall);
    }

    @Override
    public void deleteCinemaHall(int hallId) {
        cinemaHallRepository.deleteById(hallId);
    }

    @Override
    public String getHallRows(int hallId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> q = cb.createQuery(Object.class);
        Root<CinemaHall> root = q.from(CinemaHall.class);
        q.select(root.get("rows"));
        Predicate predicate = cb.equal(root.get("id"), hallId);
        q.where(predicate);
        return entityManager.createQuery(q).getSingleResult().toString();
    }
}
