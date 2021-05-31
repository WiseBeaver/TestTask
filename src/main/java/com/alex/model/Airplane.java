package com.alex.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "airplane")
@EqualsAndHashCode(of="id")
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,unique = true)
    private String factorySerialNumber;

    @Column(nullable = false,length = 75)
    private String name;

    @Column(nullable = false)
    private long numberOfFlights;

    @Column(nullable = false)
    private long flightDistance;

    @Column(nullable = false)
    private long fuelCapacity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,name = "type")
    private AirplaneType airplaneType;

    @ManyToOne
    @JoinColumn(name = "air_company_id")
    private AirCompany airCompany;

    @Column(nullable = false)
    private LocalDateTime created=LocalDateTime.now();

    public enum AirplaneType{TRANSPORT_PLANE,PASSENGER_PLANE}

}