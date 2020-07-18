package com.shcherbinina.cinemapark.dto.entity;

import java.sql.Blob;

public class MovieImageDTO {
    private int id;
    private Blob image;

    public MovieImageDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
}
