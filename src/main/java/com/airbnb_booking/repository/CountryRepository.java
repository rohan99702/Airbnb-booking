package com.airbnb_booking.repository;

import com.airbnb_booking.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}