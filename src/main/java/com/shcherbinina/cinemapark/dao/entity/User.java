package com.shcherbinina.cinemapark.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "firstName", length = 64, nullable = false)
    private String firstName;

    @Column(name = "lastName", length = 64, nullable = false)
    private String lastName;

    @Column(name = "password", length = 15, nullable = false)
    private String password;

    @Column(name = "email", length = 30, nullable = false)
    private String email;

    @Column(name = "account", nullable = false)
    private double account;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Reservation> reservations;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "userRole", joinColumns = @JoinColumn(name = "userId"))
    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    private Set<Role> roles;

    public User() {
    }

    public User(int id, String firstName, String lastName, String password, String email, double account) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.account = account;
    }
}
