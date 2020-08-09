package com.shcherbinina.cinemapark.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cinemaHall")
@Data
public class CinemaHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "rowsAmount", nullable = false)
    private int rowsAmount;

    @Column(name = "rowsTypes", nullable = false)
    private String rows;

    @Column(name = "hallName", nullable = false)
    private String hallName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cinemaHall")
    private List<MovieSession> movieSessions;

    public CinemaHall () {
    }

    public CinemaHall(int id, int rowsAmount, String rows) {
        this.id = id;
        this.rowsAmount = rowsAmount;
        this.rows = rows;
    }
}
