package com.shcherbinina.cinemapark.dto.entity;

import lombok.Data;

import java.util.List;

@Data
public class RowDTO {
    private int id;
    private int rowsAmount;
    private List<Integer> reservedPlaces;
    private List<Integer> freePlaces;


    public RowDTO(int id, int rowsAmount, List<Integer> reservedPlaces, List<Integer> freePlaces) {
        this.id = id;
        this.rowsAmount = rowsAmount;
        this.reservedPlaces = reservedPlaces;
        this.freePlaces = freePlaces;
    }
}
