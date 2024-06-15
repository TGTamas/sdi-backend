package com.example.demo.services;


import com.example.demo.models.Driver;
import com.example.demo.models.Team;
import com.example.demo.repositories.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DriverService {
    private final DriverRepository repo;

    public DriverService(DriverRepository repo) {
        this.repo = repo;
    }

    public List<Driver> getAll() {
        return repo.findAll();
    }

    public List<Driver> getAllOlderThan(Integer ageMin){
        return repo.getAllByAgeGreaterThan(ageMin);
    }

    public Optional<Driver> getById(Integer id) {
        return repo.findById(id);
    }

    public void create(Driver driver) {
        repo.save(driver);
    }

    public void update(Driver driver) {
        repo.save(driver);
    }

    public void delete(Integer id) {
        Optional<Driver> driver = repo.findById(id);
        driver.map(driver1 -> {
            driver1.setActive(false);
            repo.save(driver1);
            return driver1;
        });
        //repo.deleteById(id);
    }

    public List<Driver> getOrderByFoundation(){
        List<Driver> drivers = repo.findAll();
        return drivers.stream()
                .sorted(Comparator.comparingDouble(
                        driver->driver.getTeam().getFoundationYear()
                ))
                .toList();
    }
}
