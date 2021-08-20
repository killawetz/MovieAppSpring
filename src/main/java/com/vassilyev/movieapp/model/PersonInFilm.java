package com.vassilyev.movieapp.model;

import javax.persistence.*;

@Entity
public class PersonInFilm {

    @EmbeddedId
    private PersonInFilmId personInFilmId;

    @ManyToOne(fetch = FetchType.LAZY,
    cascade = CascadeType.REMOVE)
    @MapsId("personId")
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY,
    cascade = CascadeType.REMOVE)
    @MapsId("filmId")
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne(fetch = FetchType.LAZY,
    cascade = CascadeType.REMOVE)
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
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
