package com.example.myrunner.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "runner_table")
public class Runner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idru")
    private int idru;

    @Column(name = "name")
    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    @Column(name = "surname")
    @NotNull
    @Size(min = 2, max = 30)
    private String surname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idt")
    private Team team;

    @OneToMany(mappedBy = "runner", cascade = CascadeType.ALL)
    private Collection<Result> results = new ArrayList<>();

    

    // Getters and Setters
    public int getIdru() {
        return idru;
    }

    public void setIdru(int idru) {
        this.idru = idru;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    
 // Constructors
    public Runner() {

    }

    public Runner(String inputname, String inputsurname, Team inputteam) {
        name = inputname;
        surname = inputsurname;
        team = inputteam;
    }

    public Collection<Result> getResults() {
        return results;
    }

    public void setResults(Collection<Result> results) {
        this.results = results;
    }

    // toString
    @Override
    public String toString() {
       String result = "Runner [idru=" + idru + ", name=" + name + ", surname=" + surname + "]";
       return result;
    }
}