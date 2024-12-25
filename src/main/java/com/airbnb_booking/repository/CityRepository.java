package com.airbnb_booking.repository;

import com.airbnb_booking.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}