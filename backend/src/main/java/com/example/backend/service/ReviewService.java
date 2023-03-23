package com.example.backend.service;

import com.example.backend.model.Review;

import java.util.List;

public interface ReviewService {
    Review save(Review review);
    List<Review> findByDriverId(Long driverId);

}

