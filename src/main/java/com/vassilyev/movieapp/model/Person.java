package com.vassilyev.movieapp.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(uniqueConstraints =
        {@UniqueConstraint(columnNames = {"name", "date_of_birth"})})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "country_of_birth", referencedColumnName = "id")
    private Country countryOfBirth;

    @Column(name = "date_of_birth")
    private java.sql.Date dateOfBirth;


    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<PersonInFilm> personInFilms = new HashSet<>();

    public Person() {
    }

    public Person(String name, Country countryOfBirth, Date dateOfBirth) {
        this.name = name;
        this.countryOfBirth = countryOfBirth;
        this.dateOfBirth = dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryOfBirth(Country countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public void setDateOfBirth(java.sql.Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public Set<PersonInFilm> getPersonInFilms() {
        return personInFilms;
    }


    public Country getCountryOfBirth() {
        return countryOfBirth;
    }

    public java.util.Date getDateOfBirth() {
        return dateOfBirth;
    }
}
