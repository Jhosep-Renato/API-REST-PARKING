package com.japrova.appparking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_parking")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identifier")
    private String identifierUser;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "car_registration")
    private String carRegistration;

    @Column(name = "ticket_parking")
    private String ticketParking;

    public User() {
    }

    public String getIdentifierUser() {
        return identifierUser;
    }

    public void setIdentifierUser(String identifierUser) {
        this.identifierUser = identifierUser;
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

    public String getCarRegistration() {
        return carRegistration;
    }

    public void setCarRegistration(String carRegistration) {
        this.carRegistration = carRegistration;
    }

    public String getTicketParking() {
        return ticketParking;
    }

    public void setTicketParking(String ticketParking) {
        this.ticketParking = ticketParking;
    }
}
