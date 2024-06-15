package com.example.demo.dto;

import com.example.demo.models.IdModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
public class TeamDetailsDTO extends IdModel {
    private String name;
    private String engine;
    private Integer foundationYear;
    private String nationality;
    private String principal;
    private List<TeamDriverDTO> drivers;
}
