package com.vassilyev.movieapp.model;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.Set;

@Entity
public class PersonInFilm {

    @EmbeddedId
    private PersonInFilmId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("personId")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("filmId")
    private Film film;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("roleId")
    private Role role;

    @ManyToMany()
    private Set<PersonAward> personAwards;

    public PersonInFilm() {}

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

    public Person getPerson() {
        return person;
    }

    public Film getFilm() {
        return film;
    }

    public Role getRole() {
        return role;
    }
}