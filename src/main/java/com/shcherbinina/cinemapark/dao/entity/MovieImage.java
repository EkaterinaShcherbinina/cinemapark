package com.shcherbinina.cinemapark.dao.entity;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "movieImage")
public class MovieImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "image", nullable = false)
    @Lob
    private Blob image;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "image")
    private Movie movie;

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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
