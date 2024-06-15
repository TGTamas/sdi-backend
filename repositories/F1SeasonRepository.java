package com.example.demo.repositories;

import com.example.demo.models.F1Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface F1SeasonRepository extends JpaRepository<F1Season, Integer> {
}
