package com.shcherbinina.cinemapark.dao.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movieSession")
public class MovieSession {
    @Id
    @GeneratedValue
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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if(obj == null || obj.getClass()!= this.getClass()) return false;

        MovieSession movieSession = (MovieSession) obj;

        return movieSession.id == id &&
                movieSession.date.equals(this.date) &&
                movieSession.time.equals(this.time) &&
                Double.compare(movieSession.cost, this.cost) == 0 &&
                movieSession.cinemaHall.equals(this.cinemaHall) &&
                movieSession.movie.equals(this.movie);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + ((Integer)id).hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + ((Double)cost).hashCode();
        result = 31 * result + cinemaHall.hashCode();
        result = 31 * result + movie.hashCode();
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Reservation> getReservations() {
        return reservations;
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
