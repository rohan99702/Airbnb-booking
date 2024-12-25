package com.airbnb_booking.service;

import com.airbnb_booking.entity.Country;
import com.airbnb_booking.payload.CountryDto;
import com.airbnb_booking.repository.CountryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService
{
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ModelMapper modelMapper;

    public CountryDto saveCountry(CountryDto countryDto)
    {
        Country country=modelMapper.map(countryDto,Country.class);
        CountryDto dto=modelMapper.map(countryRepository.save(country),CountryDto.class);
        return dto;
    }
}
