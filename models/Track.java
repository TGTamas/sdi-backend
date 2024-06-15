package com.example.demo.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Track extends IdModel{
    private String name;
    private String country;
    private Double lapLength;
    private Integer nrLaps;
}
