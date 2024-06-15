package com.example.demo.dto;

import com.example.demo.models.IdModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class DriverListItemDTO extends IdModel {
    private String firstName;
    private String lastName;
    private String nationality;
    private String teamName;
}
