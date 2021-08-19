package com.vassilyev.movieapp.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PersonInFilmId implements Serializable {

    @Column(name = "person_id")
    private Long person_id;

    @Column(name = "film_id")
    private Long film_id;

    @Column(name = "role_id")
    private Long role_id;

    public PersonInFilmId() {}

    public PersonInFilmId(Long person_id, Long film_id, Long role_id) {
        this.person_id = person_id;
        this.film_id = film_id;
        this.role_id = role_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonInFilmId that = (PersonInFilmId) o;
        return Objects.equals(person_id, that.person_id) && Objects.equals(film_id, that.film_id) && Objects.equals(role_id, that.role_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person_id, film_id, role_id);
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }

    public void setFilm_id(Long film_id) {
        this.film_id = film_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public Long getPerson_id() {
        return person_id;
    }

    public Long getFilm_id() {
        return film_id;
    }

    public Long getRole_id() {
        return role_id;
    }
}
