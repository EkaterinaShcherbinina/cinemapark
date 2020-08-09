package com.shcherbinina.cinemapark.dto.entity;

import lombok.Data;

import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.Positive;

@Data
public class ReservationDTO {
    public interface New {
    }

    public interface Update {
    }

    @NegativeOrZero(message = "Id must be 0", groups = {MovieDTO.New.class})
    @Positive(message = "Id must be > 0", groups = {MovieDTO.Update.class})
    private int id;
    @Positive(message = "row must be > 0", groups = {MovieDTO.New.class, MovieDTO.Update.class})
    private int rowId;
    @Positive(message = "place must be > 0", groups = {MovieDTO.New.class, MovieDTO.Update.class})
    private int place;
    @Positive(message = "sessionId must be > 0", groups = {MovieDTO.New.class, MovieDTO.Update.class})
    private int sessionId;
    private boolean isPaid;
}
