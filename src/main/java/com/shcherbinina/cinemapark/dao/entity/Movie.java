package com.shcherbinina.cinemapark.dao.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "secondaryKey", nullable = false)
    private String secondaryKey;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "actors", nullable = false)
    private String actors;

    @Column(name = "duration", nullable = false)
    private int duration;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if(obj == null || obj.getClass()!= this.getClass()) return false;

        Movie movie = (Movie) obj;

        return movie.id == id &&
                movie.secondaryKey.equals(this.secondaryKey) &&
                movie.name.equals(this.name) &&
                movie.imageUrl.equals(this.imageUrl) &&
                movie.actors.equals(this.actors) &&
                movie.duration == duration &&
                movie.description.equals(this.description) &&
                Double.compare(movie.rating, this.rating) == 0 &&
                movie.genre.equals(this.genre) &&
                movie.producer.equals(this.producer) &&
                movie.productionYear.equals(this.producer) &&
                movie.premiereDate.equals(this.premiereDate);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + ((Integer)id).hashCode();
        result = 31 * result + secondaryKey.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + imageUrl.hashCode();
        result = 31 * result + actors.hashCode();
        result = 31 * result + ((Integer)duration).hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + ((Double)rating).hashCode();
        result = 31 * result + genre.hashCode();
        result = 31 * result + producer.hashCode();
        result = 31 * result + productionYear.hashCode();
        result = 31 * result + premiereDate.hashCode();
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    public Date getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(Date premiereDate) {
        this.premiereDate = premiereDate;
    }
}
