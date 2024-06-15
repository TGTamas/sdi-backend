package com.example.demo.controllers;

import com.example.demo.dto.TeamDetailsDTO;
import com.example.demo.dto.TeamDriverDTO;
import com.example.demo.dto.TeamListItemDTO;
import com.example.demo.mapper.TeamMapper;
import com.example.demo.models.Team;
import com.example.demo.services.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("teams")
public class TeamController {
    private final TeamService service;

    public TeamController(TeamService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<TeamListItemDTO>> getAll() {
        return ResponseEntity.ok(
                service.getAll().stream()
                        .map(TeamMapper::toListItem)
                        .toList()
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<TeamDetailsDTO> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(TeamMapper::toDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("orderByAge")
    public ResponseEntity<List<TeamListItemDTO>> getOrderByAge(){
        return ResponseEntity.ok(service.getOrderByAge().stream()
                .map(TeamMapper::toListItem)
                .toList()
        );
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Team team) {
        service.create(team);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Team team) {
        service.update(team);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
