package com.shcherbinina.cinemapark.dto.entity;

public class MovieSessionDTO {
    private int id;

    private String movieDate;

    private String time;

    private double cost;

    private CinemaHallDTO cinemaHall;

    private MovieDTO movie;

    public MovieSessionDTO() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;

        MovieSessionDTO dto = (MovieSessionDTO) obj;

        return dto.id == id &&
                dto.movieDate.equals(movieDate) &&
                dto.time.equals(time) &&
                Double.compare(dto.cost, cost) == 0 &&
                dto.cinemaHall.equals(cinemaHall) &&
                dto.movie.equals(this.movie);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + ((Integer) id).hashCode();
        result = 31 * result + movieDate.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + ((Double) cost).hashCode();
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

    public String getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
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

    public CinemaHallDTO getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHallDTO cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public MovieDTO getMovie() {
        return movie;
    }

    public void setMovie(MovieDTO movie) {
        this.movie = movie;
    }
}
