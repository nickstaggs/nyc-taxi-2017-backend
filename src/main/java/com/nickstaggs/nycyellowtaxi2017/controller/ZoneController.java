package com.nickstaggs.nycyellowtaxi2017.controller;

import com.nickstaggs.nycyellowtaxi2017.exception.ForbiddenException;
import com.nickstaggs.nycyellowtaxi2017.exception.ResourceNotFoundException;
import com.nickstaggs.nycyellowtaxi2017.model.Zone;
import com.nickstaggs.nycyellowtaxi2017.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ZoneController {

    @Autowired
    ZoneRepository zoneRepository;

    @GetMapping("/zones")
    public List<Zone> getAllZones() { return zoneRepository.findAll(); }

    @GetMapping("/zones/{id}")
    public Zone getZoneById(@PathVariable(value = "id") int zoneId) {
        return zoneRepository.findById(zoneId)
                .orElseThrow(() -> new ResourceNotFoundException("Zone", "id", zoneId));
    }

    @PostMapping("/zones")
    public ForbiddenException createZone(@Valid @RequestBody Zone zone) { return new ForbiddenException(); }

    @PutMapping("/zones/{id}")
    public ForbiddenException updateZone(@PathVariable(value = "id") int zoneId,
                                         @Valid @RequestBody Zone zone) {
        return new ForbiddenException();
    }

    @DeleteMapping("/zones/{id}")
    public ForbiddenException deleteZone(@PathVariable(value = "id") int zoneId) {
        return new ForbiddenException();
    }
}
