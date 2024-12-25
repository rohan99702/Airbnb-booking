package com.airbnb_booking.payload;

import com.airbnb_booking.entity.City;
import com.airbnb_booking.entity.Country;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDto
{
    private String property_name;
    private String no_of_bedrooms;
    private String no_of_bathrooms;
    private String no_of_beds;
    private String no_of_guests;
    private Country country;
    private City city;

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
}
