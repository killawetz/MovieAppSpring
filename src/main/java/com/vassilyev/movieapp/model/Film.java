package com.vassilyev.movieapp.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Entity()
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "year"})})
public class Film {

    public Film() {
    }

    public Film(String name,
                String description,
                int budget,
                int year,
                int runtime,
                List<Genre> genres) {
        this.name = name;
        this.description = description;
        this.budget = budget;
        this.year = year;
        this.runtime = runtime;
        this.genres = genres;
    }

    public Film(String name,
                String description,
                int budget,
                int year,
                int runtime) {
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
    @NotBlank(message = "The name field cannot be empty")
    private String name;

    @Column(name = "description")
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String description;

    @Column(name = "budget")
    @Min(value = 0, message = "The budget value must be positive")
    @Max(value = Integer.MAX_VALUE, message = "Too big value")
    private int budget;


    @Column(name = "year")
    @Min(value = 0L, message = "The year value must be positive")
    @Max(value = 2021, message = "The year value cannot be more than the current year (2021)"/* Calendar.getInstance().get(Calendar.YEAR)*/)
    private int year;


    @Column(name = "runtime")
    @Min(value = 0, message = "The runtime value must be positive")
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "genre_film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres = new ArrayList<>();

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private Set<PersonInFilm> personInFilms = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "filmId")
    private List<Screenshot> screenshots = new ArrayList<>();


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

    public Long getId() {
        return id;
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

    public List<Screenshot> getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(List<Screenshot> screenshots) {
        this.screenshots = screenshots;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return budget == film.budget && year == film.year && runtime == film.runtime && Objects.equals(id, film.id) && Objects.equals(name, film.name) && Objects.equals(description, film.description) && Objects.equals(studios, film.studios) && Objects.equals(countries, film.countries) && Objects.equals(genres, film.genres) && Objects.equals(personInFilms, film.personInFilms) && Objects.equals(screenshots, film.screenshots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, budget, year, runtime, studios, countries, genres, personInFilms, screenshots);
    }
}
