package com.vassilyev.movieapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity()
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "year"})})
public class Film {

    public Film() {
    }

    public Film(String name, String description, int budget, int year, int runtime) {
        this.name = name;
        this.description = description;
        this.budget = budget;
        this.year = year;
        this.runtime = runtime;
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "studio_film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "studio_id")
    )
    private List<Studio> studios = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "country_film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    private List<Country> countries = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "genre_film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres = new ArrayList<>();

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private Set<PersonInFilm> personInFilms = new HashSet<>();

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

    public List<Studio> getStudios() {
        return studios;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public Set<PersonInFilm> getPersonInFilms() {
        return personInFilms;
    }

    public void setStudios(List<Studio> studios) {
        this.studios = studios;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void setPersonInFilms(Set<PersonInFilm> personInFilms) {
        this.personInFilms = personInFilms;
    }
}
