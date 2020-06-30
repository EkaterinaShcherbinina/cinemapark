package com.shcherbinina.cinemapark.dao.repository;

import com.shcherbinina.cinemapark.dao.RowDAO;
import com.shcherbinina.cinemapark.dao.entity.RowCinemaHall;
import com.shcherbinina.cinemapark.dto.entity.RowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RowRepository implements IRowRepository {
    @Autowired
    private RowDAO rowDAO;
    @Autowired
    EntityManager entityManager;

    @Override
    public List<RowDTO> getPlacesByHallId(int hallId) {
        return null;//rowDAO.findAllPlacesByHall(hallId);
    }

    @Override
    public List<RowCinemaHall> getRowsByTypeIds(List<Integer> rowTypesIds) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RowCinemaHall> q = cb.createQuery(RowCinemaHall.class);
        Root<RowCinemaHall> root = q.from(RowCinemaHall.class);
        Predicate rowPredicate = root.get("id").in(rowTypesIds);
        q.where(rowPredicate);
        return entityManager.createQuery(q).getResultList();
    }
}
