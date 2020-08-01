package com.shcherbinina.cinemapark.dto.entity;

public class CinemaHallDTO {
    private int id;
    private String hallName;
    private int rowsAmount;
    private int[] placesAmountInRow;

    public CinemaHallDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRowsAmount() {
        return rowsAmount;
    }

    public void setRowsAmount(int rowsAmount) {
        this.rowsAmount = rowsAmount;
    }

    public int[] getPlacesAmountInRow() {
        return placesAmountInRow;
    }

    public void setPlacesAmountInRow(int[] placesAmountInRow) {
        this.placesAmountInRow = placesAmountInRow;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }
}
