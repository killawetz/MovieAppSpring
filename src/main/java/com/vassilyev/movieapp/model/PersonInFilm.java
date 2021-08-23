package com.vassilyev.movieapp.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class PersonInFilm {

    @EmbeddedId
    private PersonInFilmId id;

    @ManyToOne
    @MapsId("personId")
    private Person person;

    @ManyToOne
    @MapsId("filmId")
    private Film film;

    @ManyToOne
    @MapsId("roleId")
    private Role role;

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