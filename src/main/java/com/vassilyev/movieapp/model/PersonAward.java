package com.vassilyev.movieapp.model;


import javax.persistence.*;

@Entity(name = "PersonAward")
@Table(name = "person_award")
public class PersonAward {

    @EmbeddedId
    private PersonAwardId id;

    @ManyToOne
    @MapsId("personIdInFilm")
    private PersonInFilm person;

    @ManyToOne
    @MapsId("awardId")
    private Award award;

    @Column(name = "isReceived")
    private boolean isReceived;

    public PersonAward() {}

    public PersonAward(PersonAwardId id, boolean isReceived) {
        this.id = id;
        this.isReceived = isReceived;
    }

    public void setId(PersonAwardId id) {
        this.id = id;
    }

    public void setReceived(boolean received) {
        isReceived = received;
    }

    public PersonAwardId getId() {
        return id;
    }

    public boolean isReceived() {
        return isReceived;
    }
}
