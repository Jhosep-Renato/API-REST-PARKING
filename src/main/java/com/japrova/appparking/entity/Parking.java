package com.japrova.appparking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "parking")
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parking")
    private int idParking;

    @Column(name = "parking_spot")
    private String parkingSpot;

    @Column(name = "state_parking_spot")
    private String stateParkingSpot;

    @Column(name = "user_car")
    private String user;

    public Parking() {
    }

    public int getIdParking() {
        return idParking;
    }

    public void setIdParking(int idParking) {
        this.idParking = idParking;
    }

    public String getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(String parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public String getStateParkingSpot() {
        return stateParkingSpot;
    }

    public void setStateParkingSpot(String stateParkingSpot) {
        this.stateParkingSpot = stateParkingSpot;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
