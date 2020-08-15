package com.shcherbinina.cinemapark.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "rowId", nullable = false)
    private int rowId;

    @Column(name = "place", nullable = false)
    private int place;

    @Column(name = "isPaid", nullable = false)
    private boolean isPaid;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "sessionId", nullable = false)
    private MovieSession movieSession;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;

    public void assignToMovieSession(MovieSession movieSession) {
        movieSession.getReservations().add(this);
        this.movieSession = movieSession;
    }

    public void assignToUser(User user) {
        if(user != null) {
            user.getReservations().add(this);
            this.user = user;
        }
    }
}
