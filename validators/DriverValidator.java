package com.example.demo.validators;

import com.example.demo.exceptions.ValidationException;
import com.example.demo.models.Driver;

public class DriverValidator {
    public static void validateAge(Driver driver) {
        validate(driver.getAge() >= 18, "Driver underage");
    }

    private static void validate(boolean what, String message) {
        if(!what)
            throw new ValidationException(message);
    }
}
