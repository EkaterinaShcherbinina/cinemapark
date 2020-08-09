package com.shcherbinina.cinemapark.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "rowCinemaHall")
@Data
public class RowCinemaHall {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "seatsAmount", nullable = false)
    private int seatsAmount;

    public RowCinemaHall() {
    }

    public RowCinemaHall(int id, int seatsAmount) {
        this.id = id;
        this.seatsAmount = seatsAmount;
    }
}
