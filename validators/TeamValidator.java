package com.example.demo.validators;

import com.example.demo.exceptions.ValidationException;
import com.example.demo.models.Team;

public class TeamValidator {
    public static void validateFoundationYear(Team team) {
        validate(team.getFoundationYear() > 1949, "First F1 season was in 1950");
    }

    public static void validatePrincipal(Team team) {
        validate(team.getPrincipal().contains(" "), "Principal must have firstname and lastname");
    }

    private static void validate(boolean what, String message) {
        if(!what)
            throw new ValidationException(message);
    }
}
