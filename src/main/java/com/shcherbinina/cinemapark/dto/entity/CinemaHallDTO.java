package com.shcherbinina.cinemapark.dto.entity;

public class CinemaHallDTO {
    private int rowsAmount;
    private String rows;
    private String hallName;

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

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }
}
