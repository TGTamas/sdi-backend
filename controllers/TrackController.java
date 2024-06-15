package com.example.demo.controllers;

import com.example.demo.models.Team;
import com.example.demo.models.Track;
import com.example.demo.repositories.TrackRepository;
import com.example.demo.services.TeamService;
import com.example.demo.services.TrackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("tracks")
public class TrackController {
    private final TrackService service;

    public TrackController(TrackService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Track>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Track> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Track track) {
        service.create(track);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Track track) {
        service.update(track);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
