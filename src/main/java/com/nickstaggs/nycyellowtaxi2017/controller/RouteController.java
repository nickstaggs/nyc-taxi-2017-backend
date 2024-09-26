package com.nickstaggs.nycyellowtaxi2017.controller;

import com.nickstaggs.nycyellowtaxi2017.exception.ForbiddenException;
import com.nickstaggs.nycyellowtaxi2017.exception.ResourceNotFoundException;
import com.nickstaggs.nycyellowtaxi2017.model.Route;
import com.nickstaggs.nycyellowtaxi2017.repository.RouteRepository;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.util.function.Tuple2;

import javax.persistence.Tuple;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class RouteController {

    @Autowired
    RouteRepository routeRepository;

//    @GetMapping("/routes")
//    public ForbiddenException getAllRoutes() { return new ForbiddenException(); }

    @GetMapping("/routes/{id}")
    public Route getRouteById(@PathVariable(value = "id") Long routeId) {
        return routeRepository.findById(routeId)
                .orElseThrow(() -> new ResourceNotFoundException("Route", "id", routeId));
    }

    @RequestMapping(value = "/routes", method = RequestMethod.GET)
    public List<Route> getAllRoutesByPickupAndDropOffLocation(
            @RequestParam(value = "pickupLocationId", required = false) Optional<Integer> pickupLocationId,
            @RequestParam(value = "dropoffLocationId", required = false) Optional<Integer> dropoffLocationId)
            throws BadHttpRequest {
        if (pickupLocationId.isPresent() && dropoffLocationId.isPresent()) {
            return routeRepository.findByPickupLocationIdAndDropoffLocationId(
                    pickupLocationId.get(),
                    dropoffLocationId.get()
            )
            .orElseThrow(() -> new ResourceNotFoundException(
                    "Route",
                    "id",
                    String.format("%s %s", pickupLocationId, dropoffLocationId)
            ));
        } else if (pickupLocationId.isPresent()) {
            return routeRepository.findByPickupLocationId(pickupLocationId.get())
                    .orElseThrow(() -> new ResourceNotFoundException("Route", "id", pickupLocationId));
        } else if (dropoffLocationId.isPresent()) {
            return routeRepository.findByDropoffLocationId(dropoffLocationId.get())
                    .orElseThrow(() -> new ResourceNotFoundException("Route", "id", dropoffLocationId));
        } else {
            throw new BadHttpRequest();
        }
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
