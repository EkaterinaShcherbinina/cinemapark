package com.shcherbinina.cinemapark.dto.entity;

import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class BookedDTO {
    private int reservationId;
    private int rowId;
    private int place;
    private String movieName;
    private String hallName;
    private Date date;
    private Time time;
    private boolean status;
}
