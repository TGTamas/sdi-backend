package com.example.demo.repositories;

import com.example.demo.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Integer> {
    List<Driver> getAllByAgeGreaterThan(Integer age);
}
