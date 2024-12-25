package com.airbnb_booking.controller;

import com.airbnb_booking.payload.ListPropertyDto;
import com.airbnb_booking.payload.PropertyDto;
import com.airbnb_booking.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/property")
public class PropertyController
{
    @Autowired
    private PropertyService propertyService;

    //http://localhost:8080/api/v1/property?city_id=1&country_id=1
    @PostMapping
    public ResponseEntity<?> saveNewProperty(@RequestBody PropertyDto propertyDto,
                                             @RequestParam ("city_id") long city_id,
                                             @RequestParam ("country_id") long country_id)
    {
        PropertyDto dto=propertyService.saveProperty(propertyDto,city_id,country_id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //http://localhost:8080/api/v1/property?pageNo=0&pageSize=2&sortBy=id&sortDir=asc
    @GetMapping
    public ResponseEntity<?> getAllPropertirs(
            @RequestParam(name="sortBy",defaultValue ="id",required=true) String sortBy,
            @RequestParam(name="sortDir",defaultValue ="asc",required=true) String sortDir,
            @RequestParam(name="pageNo",defaultValue ="0",required=true) int pageNo,
            @RequestParam(name="pageSize",defaultValue ="2",required=true) int pageSize)
    {
        ListPropertyDto listPropertyDto=propertyService.getProperty(pageNo,pageSize,sortBy,sortDir);
        return new ResponseEntity<>(listPropertyDto,HttpStatus.OK);
    }
    //http://localhost:8080/api/v1/property/searchProperty?city=Kolkata
    @GetMapping("/searchProperty")
    public ResponseEntity<?> searchProperties(@RequestParam("city")String city)
    {
        List<PropertyDto> propertyDtos=propertyService.searchProperties(city);
        return new ResponseEntity<> (propertyDtos,HttpStatus.OK);
    }
    //http://localhost:8080/api/v1/property/searchPropertyByCityOrCountry?name=India
    @GetMapping("/searchPropertyByCityOrCountry")
    public ResponseEntity<?> searchPropertyByCityOrCountry(@RequestParam("name")String name)
    {
        List<PropertyDto> propertyDtos=propertyService.searchPropertyByCityOrCountry(name);
        return new ResponseEntity<>(propertyDtos,HttpStatus.OK);
    }
}
