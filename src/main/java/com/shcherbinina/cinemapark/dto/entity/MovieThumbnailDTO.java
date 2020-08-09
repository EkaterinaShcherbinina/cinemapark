package com.shcherbinina.cinemapark.dto.entity;

import lombok.Data;

@Data
public class MovieThumbnailDTO {
    private int id;

    private String secondaryKey;

    private String name;

    private String duration;

    private String description;

    private double rating;

    private String genre;
}
