package com.shcherbinina.cinemapark.dao.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cinemaHall")
public class CinemaHall {
    @Id
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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if(obj == null || obj.getClass()!= this.getClass()) return false;

        CinemaHall cinemaHall = (CinemaHall) obj;

        return cinemaHall.id == id &&
                cinemaHall.rowsAmount == rowsAmount &&
                cinemaHall.rows.equals(this.rows) &&
                cinemaHall.hallName.equals(this.hallName);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + ((Integer)id).hashCode();
        result = 31 * result + ((Integer)rowsAmount).hashCode();
        result = 31 * result + rows.hashCode();
        result = 31 * result + hallName.hashCode();
        return result;
    }

    public CinemaHall() {
    }

    public CinemaHall(int id, int rowsAmount, String rows) {
        this.id = id;
        this.rowsAmount = rowsAmount;
        this.rows = rows;
    }

    public CinemaHall(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

    public List<MovieSession> getMovieSessions() {
        return movieSessions;
    }

    public void setMovieSessions(List<MovieSession> movieSessions) {
        this.movieSessions = movieSessions;
    }
}
