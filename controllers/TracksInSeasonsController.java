package com.example.demo.controllers;

import com.example.demo.models.TracksInSeasons;
import com.example.demo.services.TracksInSeasonsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("tracks_in_seasons")
public class TracksInSeasonsController {
    private final TracksInSeasonsService service;

    public TracksInSeasonsController(TracksInSeasonsService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<TracksInSeasons>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<TracksInSeasons> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody TracksInSeasons tracksInSeasons) {
        service.create(tracksInSeasons);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody TracksInSeasons tracksInSeasons) {
        service.update(tracksInSeasons);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
