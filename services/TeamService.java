package com.example.demo.services;

import com.example.demo.models.Driver;
import com.example.demo.models.Team;
import com.example.demo.repositories.TeamRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private final TeamRepository repo;


    public TeamService(TeamRepository repo) {
        this.repo = repo;
    }

    public List<Team> getAll(){
        return repo.findAll();
    }

    public Optional<Team> getById(Integer id){
        return repo.findById(id);
    }

    public void create(Team team){
        repo.save(team);
    }

    public void update(Team team){
        repo.save(team);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

    public List<Team> getOrderByAge() {
        List<Team> teams = repo.findAll();
        return teams.stream()
                .sorted(Comparator.comparingDouble(
                        team -> team.getDrivers().stream()
                                .mapToDouble(Driver::getAge)
                                .average()
                                .orElse(0)
                ))
                .toList();
    }
}
