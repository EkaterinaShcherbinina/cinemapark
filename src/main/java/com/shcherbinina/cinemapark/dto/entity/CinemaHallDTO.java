package com.shcherbinina.cinemapark.dto.entity;

public class CinemaHallDTO {
    private int rowsAmount;
    private String rows;

    public CinemaHallDTO() {
    }

    public int getRowsAmount() {
        return rowsAmount;
    }

    public void setRowsAmount(int rowsAmount) {
        this.rowsAmount = rowsAmount;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }
}
