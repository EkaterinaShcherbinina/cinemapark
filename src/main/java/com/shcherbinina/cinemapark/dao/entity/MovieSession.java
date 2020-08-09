package com.shcherbinina.cinemapark.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movieSession")
@Data
public class MovieSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "dateSession", nullable = false)
    private Date date;

    @Column(name = "timeSession", nullable = false)
    private Time time;

    @Column(name = "cost", nullable = false)
    private double cost;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cinemaHallId", nullable = false)
    private CinemaHall cinemaHall;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "movieId", nullable = false)
    private Movie movie;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movieSession")
    private List<Reservation> reservations;

    public MovieSession() {
    }

    public MovieSession(int id, Date date, Time time, double cost, CinemaHall cinemaHall, Movie movie) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.cost = cost;
        this.cinemaHall = cinemaHall;
        this.movie = movie;
    }

    public void assignCinemaHall(CinemaHall cinemaHall) {
        cinemaHall.getMovieSessions().add(this);
        this.cinemaHall = cinemaHall;
    }

    public void assignMovie(Movie movie) {
        cinemaHall.getMovieSessions().add(this);
        this.movie = movie;
    }
}
