package com.airbnb_booking.controller;

import com.airbnb_booking.payload.CountryDto;
import com.airbnb_booking.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/country")
public class CountryController
{
    @Autowired
    private CountryService countryService;

    @PostMapping
    public ResponseEntity<?> addNewCountry(@RequestBody CountryDto countryDto)
    {
        CountryDto dto=countryService.saveCountry(countryDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
