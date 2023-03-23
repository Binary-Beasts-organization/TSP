package com.example.backend.controller;

import com.example.backend.model.Review;
import com.example.backend.service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @PostMapping
    public Review createReview(@RequestBody Review review){
        return reviewService.save(review);

    }
    @GetMapping("/{driverId}")
    public List<Review> getReviewsByProductId(@PathVariable Long driverId){
        return reviewService.findByDriverId(driverId);

    }
}
