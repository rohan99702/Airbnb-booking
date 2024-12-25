package com.airbnb_booking.service;

import com.airbnb_booking.entity.AppUser;
import com.airbnb_booking.entity.Property;
import com.airbnb_booking.entity.Review;
import com.airbnb_booking.payload.ReviewDto;
import com.airbnb_booking.repository.PropertyRepository;
import com.airbnb_booking.repository.ReviewRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private ModelMapper modelMapper;
    ReviewDto mapToDto(Review review){return modelMapper.map(review,ReviewDto.class);}

    public ReviewDto saveReview(ReviewDto reviewDto, long propertyID,AppUser appUser)
    {
     Property property=propertyRepository.findById(propertyID).get();
        Review review=modelMapper.map(reviewDto,Review.class);
        review.setAppUser(appUser);
        review.setProperty(property);
        Review savedReview=reviewRepository.save(review);
        return modelMapper.map(savedReview,ReviewDto.class);
    }

    public List<ReviewDto> findReviewsByUser(AppUser appUser)
    {
        List<Review> reviews=reviewRepository.findByUser(appUser);
        List<ReviewDto> reviewDtos=reviews.stream().map(n->mapToDto(n)).collect(Collectors.toList());
        return reviewDtos;
    }
}
