package com.shcherbinina.cinemapark.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "rowCinemaHall")
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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if(obj == null || obj.getClass()!= this.getClass()) return false;

        RowCinemaHall rowCinemaHall = (RowCinemaHall) obj;

        return rowCinemaHall.id == id &&
                rowCinemaHall.seatsAmount == seatsAmount;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + ((Integer)id).hashCode();
        result = 31 * result + ((Integer)seatsAmount).hashCode();
        return result;
    }

    public int getId() {
        return id;
    }

    public int getSeatsAmount() {
        return seatsAmount;
    }
}
