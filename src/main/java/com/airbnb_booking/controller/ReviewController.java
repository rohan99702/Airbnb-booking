package com.airbnb_booking.controller;


import com.airbnb_booking.entity.AppUser;
import com.airbnb_booking.entity.Property;
import com.airbnb_booking.entity.Review;
import com.airbnb_booking.payload.AppUserDto;
import com.airbnb_booking.payload.ReviewDto;
import com.airbnb_booking.repository.PropertyRepository;
import com.airbnb_booking.repository.ReviewRepository;
import com.airbnb_booking.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController //http://localhost:8080/api/v1/review/createRevicew?propertyID=1
{
    @Autowired
    private ReviewService reviewServic;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private PropertyRepository propertyRepository;

    @PostMapping("/createRevicew")
    public ResponseEntity<?> createReview(@RequestBody ReviewDto reviewDto,
                                          @AuthenticationPrincipal AppUser appUser,
                                          @RequestParam long propertyID)
    //@AuthenticationPrincipal used to track the current user.
    {
        Property property=propertyRepository.findById(propertyID).get();
        Review review=reviewRepository.findByUserAndProperty(appUser,property);
        if(review!=null)
        {
            return new ResponseEntity<>("Review exists",HttpStatus.UNAUTHORIZED);
        }
        ReviewDto dto=reviewServic.saveReview(reviewDto,propertyID,appUser);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    //http://localhost:8080/api/v1/review/userReviews
    @GetMapping("/userReviews")
    public ResponseEntity<?> getReviews(@AuthenticationPrincipal AppUser appUser)
    {
        List<ReviewDto> reviewDtos=reviewServic.findReviewsByUser(appUser);
        return new ResponseEntity<>(reviewDtos,HttpStatus.OK);
    }
}
