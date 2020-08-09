package com.shcherbinina.cinemapark.dto.entity;

import lombok.Data;

import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Data
public class CinemaHallDTO {
    public interface New {
    }

    public interface Update {
    }

    @NegativeOrZero(message = "Id must be 0", groups = {CinemaHallDTO.New.class})
    @Positive(message = "Id mustn't be 0", groups = {CinemaHallDTO.Update.class})
    private int id;

    @NotEmpty(message = "Hall name shouldn't be empty", groups = {CinemaHallDTO.New.class, CinemaHallDTO.Update.class})
    private String hallName;

    @Positive(message = "Rows amount shouldn't be empty", groups = {CinemaHallDTO.New.class, CinemaHallDTO.Update.class})
    private int rowsAmount;

    @NotEmpty(message = "All places should be set", groups = {CinemaHallDTO.New.class, CinemaHallDTO.Update.class})
    private String[] placesAmountInRow;
}
