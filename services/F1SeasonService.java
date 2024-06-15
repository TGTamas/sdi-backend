package com.example.demo.services;

import com.example.demo.models.F1Season;
import com.example.demo.repositories.F1SeasonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class F1SeasonService {
    private final F1SeasonRepository repo;

    public F1SeasonService(F1SeasonRepository repo) {
        this.repo = repo;
    }

    public List<F1Season> getAll() {
        return repo.findAll();
    }

    public Optional<F1Season> getById(Integer id) {
        return repo.findById(id);
    }

    public void create(F1Season driver) {
        repo.save(driver);
    }

    public void update(F1Season driver) {
        repo.save(driver);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
