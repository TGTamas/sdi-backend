package com.example.demo.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class F1Season extends IdModel{

    private Integer year;
    private Integer nrRaces;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer nrTeams;
}
