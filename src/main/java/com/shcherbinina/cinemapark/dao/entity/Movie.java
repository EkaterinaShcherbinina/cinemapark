package com.shcherbinina.cinemapark.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movie")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "secondaryKey", nullable = false)
    private String secondaryKey;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "actors", nullable = false)
    private String actors;

    @Column(name = "duration", nullable = false)
    private String duration;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "rating", nullable = false)
    private double rating;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "producer", nullable = false)
    private String producer;

    @Column(name = "productionYear", nullable = false)
    private String productionYear;

    @Column(name = "premiereDate", nullable = false)
    private Date premiereDate;

    @Column(name = "image")
    @Lob
    private Blob image;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "movie")
    private List<MovieSession> sessions;
}
