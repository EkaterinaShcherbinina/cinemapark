package com.shcherbinina.cinemapark.dto.entity;

import lombok.Data;

import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Data
public class AdminSessionDTO {
    public interface New {
    }

    public interface Update {
    }

    @NegativeOrZero(message = "Id must be 0", groups = {AdminSessionDTO.New.class})
    @Positive(message = "Id mustn't be 0", groups = {AdminSessionDTO.Update.class})
    private int id;

    @NotEmpty(message = "Date shouldn't be empty", groups = {AdminSessionDTO.Update.class})
    private String movieDate;

    @NotEmpty(message = "Date shouldn't be empty", groups = {AdminSessionDTO.New.class, AdminSessionDTO.Update.class})
    private String wishDate;

    @NotEmpty(message = "Time shouldn't be empty", groups = {AdminSessionDTO.New.class, AdminSessionDTO.Update.class})
    private String time;

    @NotEmpty(message = "Cost shouldn't be empty", groups = {AdminSessionDTO.New.class, AdminSessionDTO.Update.class})
    private String cost;

    @NotEmpty(message = "Hall name shouldn't be empty", groups = {AdminSessionDTO.New.class, AdminSessionDTO.Update.class})
    private String hallName;

    @NotEmpty(message = "Movie name shouldn't be empty", groups = {AdminSessionDTO.New.class, AdminSessionDTO.Update.class})
    private String movieName;
}
