package com.airbnb_booking.controller;

import com.airbnb_booking.payload.CityDto;
import com.airbnb_booking.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/city") //http://localhost:8080/api/v1/city
public class CityController
{
    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<?> addNewCity(@RequestBody CityDto cityDto)
    {
        CityDto dto=cityService.saveCity(cityDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
