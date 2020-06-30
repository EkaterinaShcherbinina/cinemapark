package com.shcherbinina.cinemapark.dao.repository;

import com.shcherbinina.cinemapark.dao.entity.RowCinemaHall;
import com.shcherbinina.cinemapark.dto.entity.RowDTO;

import java.util.List;
import java.util.Map;

public interface IRowRepository {
    List<RowDTO> getPlacesByHallId(int hallId);
    List<RowCinemaHall> getRowsByTypeIds(List<Integer> rowTypesIds);
}
