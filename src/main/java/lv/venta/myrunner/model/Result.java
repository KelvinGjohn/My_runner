package lv.venta.myrunner.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "result_table")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idr")
    private int idr;

    @Column(name = "time_in_seconds")
    @Min(1)
    private double timeInSeconds;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idru")
    private Runner runner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idra")
    private Race race;



    // Getters and Setters
    public int getIdr() {
        return idr;
    }

    public void setIdr(int idr) {
        this.idr = idr;
    }

    public double getTimeInSeconds() {
        return timeInSeconds;
    }

    public void setTimeInSeconds(double timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    public Runner getRunner() {
        return runner;
    }

    public void setRunner(Runner runner) {
        this.runner = runner;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
    
    // Constructors
    public Result() {

    }

    public Result(double inputtimeInSeconds, Runner inputrunner, Race inputrace) {
        timeInSeconds = inputtimeInSeconds;
        runner = inputrunner;
        race = inputrace;
    }

    // toString
    @Override
    public String toString() {
        String result = "Result [idr=" + idr + ", timeInSeconds=" + timeInSeconds + "]";
        return result;
    }
}