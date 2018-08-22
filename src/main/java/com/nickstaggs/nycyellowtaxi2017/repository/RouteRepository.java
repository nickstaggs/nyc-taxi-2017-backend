package com.nickstaggs.nycyellowtaxi2017.repository;

import com.nickstaggs.nycyellowtaxi2017.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    Optional<List<Route>> findByPickupLocationId(int pickupLocationId);
    Optional<List<Route>> findByDropoffLocationId(int dropoffLocationId);
}
