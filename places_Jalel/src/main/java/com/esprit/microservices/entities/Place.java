package com.esprit.microservices.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="places")
public class Place implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPlace;
    private String PlaceTitle;
    private String Description;
    private String Country;
    private String State;
    private String City;
    private String Type;

    public Place() {
    }

    public Place(int idPlace, String placeTitle, String description, String country, String state, String city, String type) {
        this.idPlace = idPlace;
        PlaceTitle = placeTitle;
        Description = description;
        Country = country;
        State = state;
        City = city;
        Type = type;
    }

    public int getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(int idPlace) {
        this.idPlace = idPlace;
    }

    public String getPlaceTitle() {
        return PlaceTitle;
    }

    public void setPlaceTitle(String placeTitle) {
        PlaceTitle = placeTitle;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
