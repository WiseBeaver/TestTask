package com.alex.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "flight")
@EqualsAndHashCode(of = "id")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FlightStatus flightStatus;

    @ManyToOne
    @JoinColumn(name = "air_company_id", nullable = false)
    private AirCompany airCompany;

    @ManyToOne
    @JoinColumn(name = "airplane_id", nullable = false)
    private Airplane airplane;

    @Column(nullable = false)
    private String departureCountry;

    @Column(nullable = false)
    private String destinationCountry;

    @Column(nullable = false)
    private long distance;

    @Column(nullable = false)
    private LocalTime estimatedFlightTime;

    private LocalDateTime started;

    private LocalDateTime ended;

    private LocalDateTime delayStarted;

    private LocalDateTime created=LocalDateTime.now();

    public enum FlightStatus {ACTIVE, COMPLETED, DELAYED, PENDING}

}
