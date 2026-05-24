package com.example.myrunner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myrunner.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

}