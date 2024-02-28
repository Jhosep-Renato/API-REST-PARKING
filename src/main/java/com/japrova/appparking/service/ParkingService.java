package com.japrova.appparking.service;

import com.japrova.appparking.entity.Parking;
import com.japrova.appparking.entity.User;

import java.util.List;
import java.util.Optional;

public interface ParkingService <T> {

    Optional<Parking> findById(int id);
    List<T> findAll();

    List<T> findAllAvailable();

    T save(User user);

    T update(T t);
}
