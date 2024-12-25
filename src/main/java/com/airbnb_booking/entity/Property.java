package com.airbnb_booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "property_name", nullable = false)
    private String property_name;

    @Column(name = "no_of_bedrooms", nullable = false)
    private String no_of_bedrooms;

    @Column(name = "no_of_bathrooms", nullable = false)
    private String no_of_bathrooms;

    @Column(name = "no_of_beds", nullable = false)
    private String no_of_beds;

    @Column(name = "no_of_guests", nullable = false)
    private String no_of_guests;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProperty_name() {
        return property_name;
    }

    public void setProperty_name(String property_name) {
        this.property_name = property_name;
    }

    public String getNo_of_bedrooms() {
        return no_of_bedrooms;
    }

    public void setNo_of_bedrooms(String no_of_bedrooms) {
        this.no_of_bedrooms = no_of_bedrooms;
    }

    public String getNo_of_bathrooms() {
        return no_of_bathrooms;
    }

    public void setNo_of_bathrooms(String no_of_bathrooms) {
        this.no_of_bathrooms = no_of_bathrooms;
    }

    public String getNo_of_beds() {
        return no_of_beds;
    }

    public void setNo_of_beds(String no_of_beds) {
        this.no_of_beds = no_of_beds;
    }

    public String getNo_of_guests() {
        return no_of_guests;
    }

    public void setNo_of_guests(String no_of_guests) {
        this.no_of_guests = no_of_guests;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}