package com.example.demo.controllers;

import com.example.demo.dto.DriverDetailsDTO;
import com.example.demo.dto.DriverListItemDTO;
import com.example.demo.mapper.DriverMapper;
import com.example.demo.models.Driver;
import com.example.demo.services.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("drivers")
public class DriverController {
    private final DriverService service;

    public DriverController(DriverService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<DriverListItemDTO>> getAll(@RequestParam(value = "age-min", required = false) Integer ageMin) {
        return ResponseEntity.ok(
                (ageMin == null ? service.getAll() : service.getAllOlderThan(ageMin)).stream()
                        .map(DriverMapper::toListItem)
                        .toList()
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<DriverDetailsDTO> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(DriverMapper::toDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("orderByFoundation")
    public ResponseEntity<List<DriverListItemDTO>> getOrderByFoundation(){
        return ResponseEntity.ok(service.getOrderByFoundation().stream()
                .map(DriverMapper::toListItem)
                .toList()
        );
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Driver driver) {
        service.create(driver);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Driver driver) {
        service.update(driver);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
