package com.nickstaggs.nycyellowtaxi2017.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Entity
@Table(name = "routes")
@Data
@JsonIgnoreProperties(allowGetters = true)
public class Route implements Serializable{

    @Id
    private Long id;

    @Column(nullable = false, updatable = false)
    private int pickupLocationId;

    @Column(nullable = false, updatable = false)
    private int dropoffLocationId;

    @Column(nullable = false, updatable = false)
    private int totalRides;
}
