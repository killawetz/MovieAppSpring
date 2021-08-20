package com.vassilyev.movieapp.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
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
    @Temporal(TemporalType.DATE)
    private java.util.Date dateOfBirth;

    @OneToMany(mappedBy = "person")
    Set<PersonAward> personAwards;

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

    public void setDateOfBirth(java.util.Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public Country getCountryOfBirth() {
        return countryOfBirth;
    }

    public java.util.Date getDateOfBirth() {
        return dateOfBirth;
    }
}
