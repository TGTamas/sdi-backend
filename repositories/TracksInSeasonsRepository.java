package com.example.demo.repositories;

import com.example.demo.models.TracksInSeasons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TracksInSeasonsRepository extends JpaRepository<TracksInSeasons, Integer> {
}
