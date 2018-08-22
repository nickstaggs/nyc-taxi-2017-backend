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

    @GetMapping("/routes")
    public ForbiddenException getAllRoutes() { return new ForbiddenException(); }

    @GetMapping("/routes/{id}")
    public Route getRouteById(@PathVariable(value = "id") Long routeId) {
        return routeRepository.findById(routeId)
                .orElseThrow(() -> new ResourceNotFoundException("Route", "id", routeId));
    }

    @RequestMapping(value = "/routes", params = "pickupLocationId", method = RequestMethod.GET)
    public List<Route> getAllRoutesByPickupLocation(@RequestParam("pickupLocationId") int pickupLocationId) {
        return routeRepository.findByPickupLocationId(pickupLocationId)
                .orElseThrow(() -> new ResourceNotFoundException("Route", "id", pickupLocationId));
    }

    @RequestMapping(value = "/routes", params = "dropoffLocationId", method = RequestMethod.GET)
    public List<Route> getAllRoutesByDropoffLocation(@RequestParam("dropoffLocationId") int dropoffLocationId) {
        return routeRepository.findByDropoffLocationId(dropoffLocationId)
                .orElseThrow(() -> new ResourceNotFoundException("Route", "id", dropoffLocationId));
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
