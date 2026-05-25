package lv.venta.myrunner.model;

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
@Table(name = "race_table")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idra")
    private int idra;

    @Column(name = "title")
    @NotNull
    @Size(min = 2, max = 50)
    private String title;

    @Column(name = "max_number_of_participants")
    @Min(1)
    private int maxNumberOfParticipants;

    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL)
    private Collection<Result> results = new ArrayList<>();

    

    // Getters and Setters
    public int getIdra() {
        return idra;
    }

    public void setIdra(int idra) {
        this.idra = idra;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxNumberOfParticipants() {
        return maxNumberOfParticipants;
    }

    public void setMaxNumberOfParticipants(int maxNumberOfParticipants) {
        this.maxNumberOfParticipants = maxNumberOfParticipants;
    }
    
 // Constructors
    public Race() {

    }

    public Race(String inputtitle, int inputmaxNumberOfParticipants) {
        title = inputtitle;
        maxNumberOfParticipants = inputmaxNumberOfParticipants;
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
        String result = "Race [idra=" + idra + ", title=" + title
                + ", maxNumberOfParticipants=" + maxNumberOfParticipants + "]";
        return result;
    }
}