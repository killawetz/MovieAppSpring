package com.vassilyev.movieapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class PersonInFilm implements Serializable {

    /*@EmbeddedId
    private PersonInFilmId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("personId")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("filmId")
    private Film film;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("roleId")
    private Role role;*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Person person;

    @ManyToOne
    private Film film;

    @ManyToOne
    private Role role;

    @OneToMany(mappedBy = "personInFilm", cascade = CascadeType.ALL)
    private List<PersonAward> personAwards = new ArrayList<>();

    public PersonInFilm() {
    }

    public PersonInFilm(Person person, Film film, Role role) {
        this.person = person;
        this.film = film;
        this.role = role;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPersonAwards(List<PersonAward> personAwards) {
        this.personAwards = personAwards;
    }

    public Person getPerson() {
        return person;
    }

    public Film getFilm() {
        return film;
    }

    public Role getRole() {
        return role;
    }

    public List<PersonAward> getPersonAwards() {
        return personAwards;
    }
}