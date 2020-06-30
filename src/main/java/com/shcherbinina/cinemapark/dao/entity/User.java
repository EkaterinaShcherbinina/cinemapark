package com.shcherbinina.cinemapark.dao.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if(obj == null || obj.getClass()!= this.getClass()) return false;

        User user = (User) obj;

        return user.id == id &&
                user.firstName.equals(this.firstName) &&
                user.lastName.equals(this.lastName) &&
                user.password.equals(this.password) &&
                user.email.equals(this.email) &&
                Double.compare(user.account, this.account) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + ((Integer)id).hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + ((Double)account).hashCode();
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }
}
