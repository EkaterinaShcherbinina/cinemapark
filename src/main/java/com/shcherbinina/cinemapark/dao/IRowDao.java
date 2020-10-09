package com.shcherbinina.cinemapark.dao;

import com.shcherbinina.cinemapark.dao.entity.RowCinemaHall;
import com.shcherbinina.cinemapark.dto.entity.RowDTO;

import java.util.List;
import java.util.Map;

public interface IRowDao {
    List<RowDTO> getPlacesByHallId(int hallId);
    List<RowCinemaHall> getRowsByTypeIds(List<Integer> rowTypesIds);
}
