package com.shcherbinina.cinemapark.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "rowId", nullable = false)
    private int rowId;

    @Column(name = "place", nullable = false)
    private int place;

    @Column(name = "isPaid", nullable = false)
    private boolean isPaid;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "sessionId", nullable = false)
    private MovieSession movieSession;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if(obj == null || obj.getClass()!= this.getClass()) return false;

        Reservation reservation = (Reservation) obj;

        return reservation.id == id &&
                reservation.rowId == rowId &&
                reservation.place == place &&
                reservation.isPaid == isPaid &&
                reservation.movieSession.equals(this.movieSession) &&
                reservation.user.equals(this.user);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + ((Integer)id).hashCode();
        result = 31 * result + ((Integer)rowId).hashCode();
        result = 31 * result + ((Integer)place).hashCode();
        result = 31 * result + ((Boolean)isPaid).hashCode();
        result = 31 * result + movieSession.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }

    public Reservation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public MovieSession getMovieSession() {
        return movieSession;
    }

    public void setMovieSession(MovieSession movieSession) {
        this.movieSession = movieSession;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void assignToMovieSession(MovieSession movieSession) {
        movieSession.getReservations().add(this);
        this.movieSession = movieSession;
    }

    public void assignToUser(User user) {
        user.getReservations().add(this);
        this.user = user;
    }
}
