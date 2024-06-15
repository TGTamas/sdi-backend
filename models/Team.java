package com.example.demo.models;

import com.example.demo.validators.TeamValidator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Team extends IdModel {

    private String name;
    private String engine;
    private Integer foundationYear;
    private String nationality;
    private String principal;
    @OneToMany(mappedBy = "team")
    @JsonManagedReference
    private List<Driver> drivers;

    @PrePersist
    @PreUpdate
    private void validate() {
        TeamValidator.validateFoundationYear(this);
        TeamValidator.validatePrincipal(this);
    }
}
