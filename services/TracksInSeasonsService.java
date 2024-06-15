package com.example.demo.services;

import com.example.demo.models.TracksInSeasons;
import com.example.demo.repositories.TracksInSeasonsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TracksInSeasonsService {
    private final TracksInSeasonsRepository repo;


    public TracksInSeasonsService(TracksInSeasonsRepository repo) {
        this.repo = repo;
    }

    public List<TracksInSeasons> getAll(){
        return repo.findAll();
    }

    public Optional<TracksInSeasons> getById(Integer id){
        return repo.findById(id);
    }

    public void create(TracksInSeasons tracksInSeasons){
        repo.save(tracksInSeasons);
    }

    public void update(TracksInSeasons tracksInSeasons){
        repo.save(tracksInSeasons);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }
}
