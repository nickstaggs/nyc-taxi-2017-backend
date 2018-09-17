package com.nickstaggs.nycyellowtaxi2017.controller;

import com.nickstaggs.nycyellowtaxi2017.exception.ForbiddenException;
import com.nickstaggs.nycyellowtaxi2017.exception.ResourceNotFoundException;
import com.nickstaggs.nycyellowtaxi2017.model.Route;
import com.nickstaggs.nycyellowtaxi2017.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RouteController {

    @Autowired
    RouteRepository routeRepository;

    @CrossOrigin(origins = "*")
    @GetMapping("/routes/{id}")
    public Route getRouteById(@PathVariable(value = "id") Long routeId) {
        return routeRepository.findById(routeId)
                .orElseThrow(() -> new ResourceNotFoundException("Route", "id", routeId));
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/routes", method = RequestMethod.GET)
    public List<Route> getRouteByPickupLocationAndDropoffLocation(@RequestParam(value = "pickupLocationId", required = false) Integer pickupLocationId,
                                                            @RequestParam(value = "dropoffLocationId", required = false) Integer dropoffLocationId) {

        if (pickupLocationId == null && dropoffLocationId == null) {
            throw new ForbiddenException();
        }

        if (pickupLocationId != null && dropoffLocationId == null) {
            return routeRepository.findByPickupLocationId(pickupLocationId)
                    .orElseThrow(() -> new ResourceNotFoundException("Route", "id", pickupLocationId));
        }

        if (pickupLocationId == null && dropoffLocationId != null) {
            return routeRepository.findByDropoffLocationId(dropoffLocationId)
                    .orElseThrow(() -> new ResourceNotFoundException("Route", "id", dropoffLocationId));
        }

        return routeRepository.findByPickupLocationIdAndDropoffLocationId(pickupLocationId, dropoffLocationId)
                .orElseThrow(() -> new ResourceNotFoundException("Route", "id", pickupLocationId.toString() + " and " + dropoffLocationId.toString()));
    }

    @PostMapping("/routes")
    public ForbiddenException createRoute(@Valid @RequestBody Route route) { return new ForbiddenException(); }

    @PutMapping("/routes/{id}")
    public ForbiddenException updateRoute(@PathVariable(value = "id") Long routeId,
                                          @Valid @RequestBody Route route) {
        return new ForbiddenException();
    }

    @DeleteMapping("/routes/{id}")
    public ForbiddenException deleteRoute(@PathVariable(value = "id") Long routeId) {
        return new ForbiddenException();
    }
}
