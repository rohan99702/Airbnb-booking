package com.airbnb_booking.service;

import com.airbnb_booking.entity.City;
import com.airbnb_booking.payload.CityDto;
import com.airbnb_booking.repository.CityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private ModelMapper modelMapper;

    public CityDto saveCity(CityDto cityDto) {
        City city = modelMapper.map(cityDto, City.class);
        City savedCity = cityRepository.save(city);
        CityDto dto = modelMapper.map(savedCity, CityDto.class);
        return dto;
    }
}