package com.alex.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "air_company")
@EqualsAndHashCode(of="id")
public class AirCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 75)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CompanyType companyType;

    @Column(nullable = false)
    private LocalDate founded=LocalDate.now();

    public enum CompanyType{MAJOR,NATIONAL,REGIONAL}
}
