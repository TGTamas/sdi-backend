package com.example.demo.services;

import com.example.demo.models.Track;
import com.example.demo.repositories.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService {
    private final TrackRepository repo;


    public TrackService(TrackRepository repo) {
        this.repo = repo;
    }

    public List<Track> getAll(){
        return repo.findAll();
    }

    public Optional<Track> getById(Integer id){
        return repo.findById(id);
    }

    public void create(Track track){
        repo.save(track);
    }

    public void update(Track track){
        repo.save(track);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }
}
