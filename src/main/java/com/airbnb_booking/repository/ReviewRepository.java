package com.airbnb_booking.repository;

import com.airbnb_booking.entity.AppUser;
import com.airbnb_booking.entity.Property;
import com.airbnb_booking.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>
{
    @Query("SELECT r from Review r where r.property=:property and r.appUser=:appUser")
    Review findByUserAndProperty(@Param("appUser")AppUser appUser,
                                 @Param("property") Property property);

    @Query("SELECT r from Review r where r.appUser=:appUser")
    List<Review> findByUser(@Param("appUser") AppUser appUser);
}