package com.example.myrunner.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "team_table")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idt")
    private int idt;

    @Column(name = "title")
    @NotNull
    @Size(min = 2, max = 50)
    private String title;

    @Column(name = "points")
    @Min(0)
    private double points;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private Collection<Runner> runners = new ArrayList<>();

    
    // Getters and Setters
    public int getIdt() {
        return idt;
    }

    public void setIdt(int idt) {
        this.idt = idt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public Collection<Runner> getRunners() {
        return runners;
    }

    public void setRunners(Collection<Runner> runners) {
        this.runners = runners;
    }
    
 // Constructors
    public Team() {

    }

    public Team(String inputtitle, double inputpoints) {
        title = inputtitle;
        points = inputpoints;
    }

    // toString
    @Override
    public String toString() {
      String result = "Team [idt=" + idt + ", title=" + title + ", points=" + points + "]";
    	return result;
    }


}
