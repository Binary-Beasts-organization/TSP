package com.example.backend.service;

import com.example.backend.model.Review;
import com.example.backend.repository.ReviewRepository;

import java.util.List;

public class ReviewServiceImpl implements ReviewService{
  public final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);


    }

    @Override
    public List<Review> findByDriverId(Long driverId) {
        return reviewRepository.findDriverId(driverId);

    }
}
