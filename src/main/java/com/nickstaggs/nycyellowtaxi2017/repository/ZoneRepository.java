package com.nickstaggs.nycyellowtaxi2017.repository;

import com.nickstaggs.nycyellowtaxi2017.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Integer> {


}
