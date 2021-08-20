package com.vassilyev.movieapp.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PersonInFilmId implements Serializable {

    @Column(name = "person_id")
    private Long personId;

    @Column(name = "film_id")
    private Long filmId;

    @Column(name = "role_id")
    private Long roleId;

    public PersonInFilmId() {}

    public PersonInFilmId(Long personId, Long filmId, Long role_id) {
        this.personId = personId;
        this.filmId = filmId;
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonInFilmId that = (PersonInFilmId) o;
        return Objects.equals(personId, that.personId) && Objects.equals(filmId, that.filmId) && Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, filmId, roleId);
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPersonId() {
        return personId;
    }

    public Long getFilmId() {
        return filmId;
    }

    public Long getRoleId() {
        return roleId;
    }
}
