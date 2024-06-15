package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class TracksInSeasons extends IdModel{
    @ManyToOne
    private F1Season season;
    @ManyToOne
    private Track track;

    private LocalDate startDate;
    private LocalDate endDate;
}
