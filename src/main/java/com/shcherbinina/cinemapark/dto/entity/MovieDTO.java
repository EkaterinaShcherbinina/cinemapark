package com.shcherbinina.cinemapark.dto.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class MovieDTO {

    private int id;
    @NotBlank
    @NotNull
    private String secondaryKey;
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private int imageId;
    @NotBlank
    @NotNull
    private String actors;
    @NotBlank
    private int duration;
    @NotBlank
    @NotNull
    private String description;
    @NotBlank
    @Min(value=1)
    @Max(value=10)
    private double rating;
    @NotBlank
    @NotNull
    private String genre;
    @NotBlank
    @NotNull
    private String producer;
    @NotBlank
    @NotNull
    private String productionYear;
    @NotBlank
    @NotNull
    private Date premiereDate;

    public MovieDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSecondaryKey() {
        return secondaryKey;
    }

    public void setSecondaryKey(String secondaryKey) {
        this.secondaryKey = secondaryKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String production_year) {
        this.productionYear = production_year;
    }

    public Date getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(Date premiereDate) {
        this.premiereDate = premiereDate;
    }
}
