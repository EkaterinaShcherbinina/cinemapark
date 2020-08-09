package com.shcherbinina.cinemapark.dto.entity;

import lombok.Data;

@Data
public class MovieSessionDTO {
    private int id;

    private String movieDate;

    private String time;

    private String cost;

    private CinemaHallDTO cinemaHall;

    private MovieDTO movie;
}
