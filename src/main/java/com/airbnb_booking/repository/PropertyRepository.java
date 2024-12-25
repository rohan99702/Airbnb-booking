package com.airbnb_booking.repository;

import com.airbnb_booking.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long>
{
   // @Query("SELECT p from Property p JOIN City c ON p.city=c.id WHERE c.city_name=:name")
    @Query("SELECT p from Property p INNER JOIN p.city c WHERE c.city_name=:name")
    List<Property> searchProperties(@Param("name")String city);

   //@Query("SELECT p FROM Property p WHERE p.city.city_name=:name OR p.country.country_name=:name")
    @Query("SELECT p from Property p INNER JOIN p.city c INNER JOIN p.country co WHERE c.city_name=:name OR co.country_name=:name")
    List<Property> searchPropertiesByCityOrCountry(@Param("name") String name);
}