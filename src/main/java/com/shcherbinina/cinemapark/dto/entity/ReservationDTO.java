package com.shcherbinina.cinemapark.dto.entity;

public class ReservationDTO {
    private int id;
    private int userId;
    private int rowId;
    private int place;
    private int sessionId;
    private boolean isPaid;

    public ReservationDTO() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if(obj == null || obj.getClass()!= this.getClass()) return false;

        ReservationDTO dto = (ReservationDTO) obj;

        return dto.id == id &&
                dto.rowId == rowId &&
                dto.place == place &&
                dto.userId == userId &&
                dto.sessionId == sessionId &&
                dto.isPaid == isPaid;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + ((Integer)id).hashCode();
        result = 31 * result + ((Integer)rowId).hashCode();
        result = 31 * result + ((Integer)place).hashCode();
        result = 31 * result + ((Integer)userId).hashCode();
        result = 31 * result + ((Integer)sessionId).hashCode();
        result = 31 * result + ((Boolean)isPaid).hashCode();
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean paid) {
        isPaid = paid;
    }
}
