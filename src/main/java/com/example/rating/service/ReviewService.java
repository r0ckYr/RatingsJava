package com.example.rating.service;

import com.example.rating.model.Review;
import com.example.rating.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public Review createreview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getAllreviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getreviewById(Long reviewId) {
        return reviewRepository.findById(reviewId);
    }

    public List<Review> getReviewByMentorId(Long mentorId)
    {
        return reviewRepository.findByMentorId(mentorId);
    }
}
