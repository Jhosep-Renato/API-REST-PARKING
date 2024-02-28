package com.japrova.appparking.service;

import com.japrova.appparking.dao.ParkingRepository;
import com.japrova.appparking.dao.UserRepository;
import com.japrova.appparking.entity.Parking;
import com.japrova.appparking.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingServiceImpl implements ParkingService <Parking> {

    private ParkingRepository parkingRepository;

    private UserRepository userRepository;


    @Autowired
    public ParkingServiceImpl(ParkingRepository parkingRepository, UserRepository userRepository) {
        this.parkingRepository = parkingRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Parking> findById(int id) {
        return parkingRepository.findById(id);
    }

    @Override
    public List<Parking> findAll() {
        return parkingRepository.findAll();
    }

    @Override
    public List<Parking> findAllAvailable() {

        return findAll().stream()
                .filter(p -> p.getStateParkingSpot().equals("f"))
                .toList();
    }

    @Override
    @Transactional
    public Parking update(Parking parking) {

        Parking getParking = null;

        if (parking.getStateParkingSpot().equals("f")) {
            parking.setStateParkingSpot("b");
            getParking = parkingRepository.save(parking);

        } else {
            parking.setUser(null);
            parking.setStateParkingSpot("f");
            getParking = parkingRepository.save(parking);
        }

        return getParking;
    }

    @Override
    @Transactional
    public Parking save(User user) {

        List<Parking> parkingsAvailable = findAllAvailable();

        if (parkingsAvailable.isEmpty()) {
            return null;
        }
        Parking parking = parkingsAvailable.get((int) (Math.random() * parkingsAvailable.size()));

        user.setTicketParking(parking.getParkingSpot());

        parking.setUser(user.getCarRegistration());

        Parking parkingUpdate = update(parking);

        userRepository.save(user);

        return parkingUpdate;
    }
}
