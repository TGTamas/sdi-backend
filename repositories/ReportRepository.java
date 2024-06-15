package com.example.demo.repositories;

import com.example.demo.models.Driver;

import java.util.List;

public interface ReportRepository {
    List<Driver> findAll();
}
