package com.example.demo.models;

import com.example.demo.validators.DriverValidator;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "active = 1")
public class Driver extends IdModel {

    private String firstName;
    private String lastName;
    private Integer age;
    private String gender;
    private String nationality;
    @ManyToOne
    @JsonBackReference
    private Team team;
    @Column(columnDefinition = "BIT DEFAULT 1")
    private Boolean active;

    @PrePersist
    @PreUpdate
    private void validate() {
        DriverValidator.validateAge(this);
    }
}
