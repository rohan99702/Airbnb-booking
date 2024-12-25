package com.airbnb_booking.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDto
{
    private String city_name;

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }
}
