package com.shcherbinina.cinemapark.dto.entity;

public class AdminSessionDTO {
    private int id;

    private String movieDate;

    private String wishDate;

    private String time;

    private double cost;

    private String hallName;

    private String movieName;

    public AdminSessionDTO() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if(obj == null || obj.getClass()!= this.getClass()) return false;

        AdminSessionDTO dto = (AdminSessionDTO) obj;

        return dto.id == id &&
                dto.movieDate.equals(movieDate) &&
                dto.wishDate.equals(wishDate) &&
                dto.time.equals(time) &&
                Double.compare(dto.cost, cost) == 0 &&
                dto.hallName.equals(hallName) &&
                dto.movieName.equals(this.movieName);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + ((Integer)id).hashCode();
        result = 31 * result + movieDate.hashCode();
        result = 31 * result + wishDate.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + ((Double)cost).hashCode();
        result = 31 * result + hallName.hashCode();
        result = 31 * result + movieName.hashCode();
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    public String getWishDate() {
        return wishDate;
    }

    public void setWishDate(String wishDate) {
        this.wishDate = wishDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
