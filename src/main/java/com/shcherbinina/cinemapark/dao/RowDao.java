package com.shcherbinina.cinemapark.dao;

import com.shcherbinina.cinemapark.dao.entity.RowCinemaHall;
import com.shcherbinina.cinemapark.dao.repository.RowRepository;
import com.shcherbinina.cinemapark.dto.entity.RowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class RowDao implements IRowDao {
    @Autowired
    private RowRepository rowRepository;
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
