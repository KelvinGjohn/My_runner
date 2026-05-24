package com.example.myrunner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myrunner.model.Race;

@Repository
public interface RaceRepository extends JpaRepository<Race, Integer> {

}