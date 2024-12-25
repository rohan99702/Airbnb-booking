package com.airbnb_booking.service;

import com.airbnb_booking.entity.City;
import com.airbnb_booking.entity.Country;
import com.airbnb_booking.entity.Property;
import com.airbnb_booking.payload.ListPropertyDto;
import com.airbnb_booking.payload.PropertyDto;
import com.airbnb_booking.repository.CityRepository;
import com.airbnb_booking.repository.CountryRepository;
import com.airbnb_booking.repository.PropertyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ModelMapper modelMapper;

    PropertyDto mapToDto (Property property)
    {
        return modelMapper.map(property,PropertyDto.class);
    }

    public PropertyDto saveProperty(PropertyDto propertyDto, long cityId, long countryId)
    {

        Country country=countryRepository.findById(countryId).get();
        City city=cityRepository.findById(cityId).get();

        Property property=modelMapper.map(propertyDto,Property.class);
        property.setCity(city);
        property.setCountry(country);
        Property savedProperty=propertyRepository.save(property);

        return modelMapper.map(savedProperty,PropertyDto.class);
    }

    public ListPropertyDto getProperty(int pageNo, int pageSize, String sortBy, String sortDir)
    {

        Sort sort=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortBy).ascending():Sort.by(sortBy).descending();

        Pageable pageable= PageRequest.of(pageNo,pageSize,sort);
        Page<Property> property=propertyRepository.findAll(pageable);
        List<Property> properties=property.getContent();
        List<PropertyDto> propertyDto=properties.stream().map(n->mapToDto(n)).collect(Collectors.toList());

        ListPropertyDto listPropertyDto=new ListPropertyDto();
        listPropertyDto.setPropertyDto(propertyDto);
        listPropertyDto.setFirstPage(property.isFirst());
        listPropertyDto.setLastPage(property.isLast());
        listPropertyDto.setTotalPage(property.getTotalPages());
        listPropertyDto.setTotalElement((int)property.getTotalElements());
        listPropertyDto.setPageNumber(property.getNumber());

        return listPropertyDto;

    }

    public List<PropertyDto> searchProperties(String city)
    {
        List<Property> properties=propertyRepository.searchProperties(city);
        List<PropertyDto> propertyDtos=properties.stream().map(n->mapToDto(n)).collect(Collectors.toList());
        return propertyDtos;
    }

    public List<PropertyDto> searchPropertyByCityOrCountry(String name)
    {
        List<Property> properties=propertyRepository.searchPropertiesByCityOrCountry(name);
        List<PropertyDto> propertyDtos=properties.stream().map(n->mapToDto(n)).collect(Collectors.toList());
        return propertyDtos;
    }
}
