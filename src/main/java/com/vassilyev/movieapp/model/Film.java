package com.vassilyev.movieapp.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity()
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "year"})})
public class Film {

    public Film() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "budget")
    private int budget;

    @Column(name = "year")
    private int year;


    @Column(name = "runtime")
    private int runtime;


    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinTable(name = "studio_film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "studio_id")
    )
    private List<Studio> studios;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinTable(name = "country_film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    private List<Country> countries;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinTable(name = "genre_film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;

    @OneToMany(mappedBy = "person")
    private Set<PersonInFilm> personInFilms;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getBudget() {
        return budget;
    }

    public int getYear() {
        return year;
    }

    public int getRuntime() {
        return runtime;
    }


}
