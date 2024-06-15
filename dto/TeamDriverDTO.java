package com.example.demo.dto;

import com.example.demo.models.IdModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class TeamDriverDTO extends IdModel {
    private String fullName;
}
