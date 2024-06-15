package com.example.demo.controllers;

import com.example.demo.models.F1Season;
import com.example.demo.services.F1SeasonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("seasons")
public class F1SeasonController {
    private final F1SeasonService service;


    public F1SeasonController(F1SeasonService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<F1Season>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<F1Season> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody F1Season f1Season) {
        service.create(f1Season);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody F1Season f1Season) {
        service.update(f1Season);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
