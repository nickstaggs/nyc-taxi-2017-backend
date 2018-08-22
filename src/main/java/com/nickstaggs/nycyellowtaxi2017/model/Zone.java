package com.nickstaggs.nycyellowtaxi2017.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Entity
@Table(name = "zones")
@Data
@JsonIgnoreProperties(allowGetters = true)
public class Zone implements Serializable{

    @Id
    private Integer locationId;

    @Column(nullable = false, updatable = false)
    private String borough;

    @Column(nullable = false, updatable = false)
    private String zone;

    @Column(nullable = false, updatable = false)
    private String serviceZone;
}
