package com.airbnb_booking.payload;

import com.airbnb_booking.entity.AppUser;
import com.airbnb_booking.entity.Property;

public class ReviewDto
{
    private String rating;
    private String description;
    private AppUser appUser;
    private Property property;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
