package com.vassilyev.movieapp.model;

import javax.persistence.*;

@Entity
public class PersonInFilm {

    @EmbeddedId
    private PersonInFilmId personInFilmId;

    @ManyToOne
    @MapsId("personId")
    private Person person;

    @ManyToOne
    @MapsId("filmId")
    private Film film;

    @ManyToOne
    @MapsId("roleId")
    private Role role;

    /*@ManyToOne
    @MapsId("person")
    private PersonAward personAward;*/

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
