package com.shcherbinina.cinemapark.dto.entity;

import java.util.List;

public class RowDTO {
    private int id;
    private int rowsAmount;
    private List<Integer> reservedPlaces;
    private List<Integer> freePlaces;


    public RowDTO(int id, int rowsAmount, List<Integer> reservedPlaces, List<Integer> freePlaces) {
        this.id = id;
        this.rowsAmount = rowsAmount;
        this.reservedPlaces = reservedPlaces;
        this.freePlaces = freePlaces;
    }

    public RowDTO() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if(obj == null || obj.getClass()!= this.getClass()) return false;

        RowDTO dto = (RowDTO) obj;

        return dto.id == id &&
                dto.rowsAmount == rowsAmount &&
                dto.reservedPlaces.equals(this.reservedPlaces) &&
                dto.freePlaces.equals(this.freePlaces);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + ((Integer)id).hashCode();
        result = 31 * result + ((Integer)rowsAmount).hashCode();
        result = 31 * result + reservedPlaces.hashCode();
        result = 31 * result + freePlaces.hashCode();
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRowsAmount() {
        return rowsAmount;
    }

    public void setRowsAmount(int rowsAmount) {
        this.rowsAmount = rowsAmount;
    }

    public List<Integer> getReservedPlaces() {
        return reservedPlaces;
    }

    public void setReservedPlaces(List<Integer> reservedPlaces) {
        this.reservedPlaces = reservedPlaces;
    }

    public List<Integer> getFreePlaces() {
        return freePlaces;
    }

    public void setFreePlaces(List<Integer> freePlaces) {
        this.freePlaces = freePlaces;
    }
}
