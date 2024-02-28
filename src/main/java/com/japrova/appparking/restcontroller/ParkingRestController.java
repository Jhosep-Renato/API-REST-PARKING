package com.japrova.appparking.restcontroller;

import com.japrova.appparking.entity.Parking;
import com.japrova.appparking.entity.User;
import com.japrova.appparking.exceptions.ParkingAvailableNotFound;
import com.japrova.appparking.exceptions.ParkingErrorResponse;
import com.japrova.appparking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ParkingRestController {


    private ParkingService<Parking> parkingService;


    @Autowired
    public ParkingRestController(ParkingService<Parking> parkingDAO) {
        this.parkingService = parkingDAO;
    }

    @GetMapping("/parking/{idParking}")
    public Parking findById(@PathVariable int idParking) {

        Optional<Parking> parkingOptional = parkingService.findById(idParking);

        if(parkingOptional.isPresent()) {
            return parkingOptional.get();
        }
        throw new ParkingAvailableNotFound("Parking not found");
    }

    @GetMapping("/parking")
    public List<Parking> findAll() {
        return parkingService.findAll();
    }

    @GetMapping("/parking-available")
    public List<Parking> findAllAvailable() {

        List<Parking> parkingsAvailable =  parkingService.findAllAvailable();

        if (parkingsAvailable.isEmpty()) {
            throw new ParkingAvailableNotFound("Available Parking not found");
        }
        return parkingsAvailable;
    }

    @PostMapping("/park-car")
    public Parking save(@RequestBody User user) {

        Parking parking = parkingService.save(user);

        if(parking == null) {
            throw new ParkingAvailableNotFound("The car park is full");
        }

        return parking;
    }

    @PutMapping("/update-parking")
    public Parking updateParking(@RequestBody Parking parking) {
        return parkingService.update(parking);
    }

    @ExceptionHandler
    public ResponseEntity<ParkingErrorResponse> handleException(ParkingAvailableNotFound exc) {

        ParkingErrorResponse parkingError = new ParkingErrorResponse();

        parkingError.setStatus(HttpStatus.NOT_FOUND.value());
        parkingError.setMessage(exc.getMessage());
        parkingError.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(parkingError, HttpStatus.NOT_FOUND);
    }
}