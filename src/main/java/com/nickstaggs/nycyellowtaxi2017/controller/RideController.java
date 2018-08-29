package com.nickstaggs.nycyellowtaxi2017.controller;

import com.nickstaggs.nycyellowtaxi2017.exception.ForbiddenException;
import com.nickstaggs.nycyellowtaxi2017.exception.ResourceNotFoundException;
import com.nickstaggs.nycyellowtaxi2017.model.Ride;
import com.nickstaggs.nycyellowtaxi2017.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RideController {

    @Autowired
    RideRepository rideRepository;

    //Get all rides
    @GetMapping("/rides")
    public ForbiddenException getAllRides() {
        return new ForbiddenException();
    }

    //Get single ride
    @CrossOrigin(origins = "*")
    @GetMapping("/rides/{id}")
    public Ride getRideById(@PathVariable(value = "id") Integer rideId) {
        return rideRepository.findById(rideId)
                .orElseThrow(() -> new ResourceNotFoundException("Ride", "id", rideId));
    }

    //Post ride
    @PostMapping("/rides")
    public ForbiddenException createRide(@Valid @RequestBody Ride ride) {
        return new ForbiddenException();
    }

    //Update ride
    @PutMapping("/rides/{id}")
    public ForbiddenException updateRide(@PathVariable(value = "id") Integer rideId,
                                         @Valid @RequestBody Ride ride) {
        return new ForbiddenException();
    }

    //Delete ride
    @DeleteMapping("/rides/{id}")
    public ForbiddenException deleteNote(@PathVariable(value = "id") Integer rideId) {
        return new ForbiddenException();
    }


}
