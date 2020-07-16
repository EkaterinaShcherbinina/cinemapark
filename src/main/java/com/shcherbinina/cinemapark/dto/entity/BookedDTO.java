package com.shcherbinina.cinemapark.dto.entity;

import java.sql.Time;
import java.util.Date;

public class BookedDTO {
    private int reservationId;
    private int rowId;
    private int place;
    private String movieName;
    private String hallName;
    private Date date;
    private Time time;
    private boolean status;

    public BookedDTO() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if(obj == null || obj.getClass()!= this.getClass()) return false;

        BookedDTO dto = (BookedDTO) obj;

        return dto.reservationId == reservationId &&
                dto.place == place &&
                dto.rowId == rowId &&
                dto.movieName.equals(this.movieName) &&
                dto.hallName.equals(this.hallName) &&
                dto.date.equals(this.date) &&
                dto.time.equals(this.time) &&
                dto.status == this.status;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + ((Integer)reservationId).hashCode();
        result = 31 * result + ((Integer)rowId).hashCode();
        result = 31 * result + ((Integer)place).hashCode();
        result = 31 * result + movieName.hashCode();
        result = 31 * result + hallName.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + ((Boolean)status).hashCode();
        return result;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
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

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
