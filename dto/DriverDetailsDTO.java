package com.example.demo.dto;

import com.example.demo.models.IdModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class DriverDetailsDTO extends IdModel {
    private String firstName;
    private String lastName;
    private Integer age;
    private String gender;
    private String nationality;
    private DriverTeamDTO team;
}
