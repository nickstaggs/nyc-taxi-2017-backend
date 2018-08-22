package com.nickstaggs.nycyellowtaxi2017.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name = "rides")
@Data
@JsonIgnoreProperties(allowGetters = true)
public class Ride implements Serializable {

    @Id
    private Integer id;

    @Column(nullable = false, updatable = false)
    private int vendorId;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date pickupDatetime;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dropoffDatetime;

    @Column(nullable = false, updatable = false)
    private int passengerCount;

    @Column(nullable = false, updatable = false)
    private float tripDistance;

    @Column(nullable = false, updatable = false)
    private int rateCodeId;

    @Column(nullable = false, updatable = false)
    private char storeAndFwdFlag;

    @Column(nullable = false, updatable = false)
    private int pickupLocationId;

    @Column(nullable = false, updatable = false)
    private int dropoffLocationId;

    @Column(nullable = false, updatable = false)
    private int paymentType;

    @Column(nullable = false, updatable = false)
    private float fareAmount;

    @Column(nullable = false, updatable = false)
    private float extra;

    @Column(nullable = false, updatable = false)
    private float mtaTax;

    @Column(nullable = false, updatable = false)
    private float tipAmount;

    @Column(nullable = false, updatable = false)
    private float tollsAmount;

    @Column(nullable = false, updatable = false)
    private float improvementSurcharge;

    @Column(nullable = false, updatable = false)
    private float totalAmount;
}
