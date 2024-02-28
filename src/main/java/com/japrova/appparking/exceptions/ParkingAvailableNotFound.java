package com.japrova.appparking.exceptions;

public class ParkingAvailableNotFound extends RuntimeException {

    public ParkingAvailableNotFound(String message) {
        super(message);
    }

    public ParkingAvailableNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
