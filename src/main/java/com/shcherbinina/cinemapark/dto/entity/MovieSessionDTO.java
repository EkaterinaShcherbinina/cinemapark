package com.shcherbinina.cinemapark.dto.entity;

import java.sql.Time;
import java.util.Date;

public class MovieSessionDTO {
    private int id;

    private int movieId;

    private Date date;

    private Time time;

    private double cost;

    private int cinemaHallId;

    public MovieSessionDTO() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if(obj == null || obj.getClass()!= this.getClass()) return false;

        MovieSessionDTO dto = (MovieSessionDTO) obj;

        return dto.id == id &&
                dto.movieId == movieId &&
                dto.date.equals(date) &&
                dto.time.equals(time) &&
                Double.compare(dto.cost, cost) == 0 &&
                dto.cinemaHallId == cinemaHallId;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + ((Integer)id).hashCode();
        result = 31 * result + ((Integer)movieId).hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + ((Double)cost).hashCode();
        result = 31 * result + ((Integer)cinemaHallId).hashCode();
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
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

    public int getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(int cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }
}
