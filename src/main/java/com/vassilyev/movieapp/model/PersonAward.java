package com.vassilyev.movieapp.model;


import javax.persistence.*;

@Entity(name = "PersonAward")
@Table(name = "person_award")
public class PersonAward {

    @EmbeddedId
    private PersonAwardId id;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE)
    private PersonInFilm person;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE)
    private Award award;

    @Column(name = "isReceived")
    private boolean isReceived;

    public PersonAward() {}

    public PersonAward(PersonInFilm person, Award award, boolean isReceived) {
        this.person = person;
        this.award = award;
        this.isReceived = isReceived;
    }

    public void setPerson(PersonInFilm person) {
        this.person = person;
    }

    public void setAward(Award award) {
        this.award = award;
    }

    public void setReceived(boolean received) {
        isReceived = received;
    }

    public PersonInFilm getPerson() {
        return person;
    }

    public Award getAward() {
        return award;
    }

    public boolean isReceived() {
        return isReceived;
    }
}
