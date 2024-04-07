package com.example.rating.service;

import com.example.rating.dto.MentorReviewResponse;
import com.example.rating.model.Mentor;
import com.example.rating.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.rating.repository.MentorRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private ReviewService reviewService;

    public Mentor createMentor(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    public List<Mentor> getAllMentors() {
        return mentorRepository.findAll();
    }

    public Optional<Mentor> getMentorById(Long mentorId) {
        return mentorRepository.findById(mentorId);
    }

    public void rateMentor(Mentor mentor, int rating)
    {
        double initialRating = mentor.getOverallRating();
        double numberOfRatings = mentor.getNumberOfRatings();

        double newRating = ((initialRating * numberOfRatings) + rating) / (numberOfRatings + 1);

        mentor.setOverallRating(newRating);
        mentor.setNumberOfRatings(numberOfRatings + 1);
        mentorRepository.save(mentor);
    }

    public List<Mentor> getMentorsByRating(Integer rating)
    {
        return mentorRepository.findByOverallRatingInRange(rating, rating+1);
    }

    public List<MentorReviewResponse> getMentorsWithReviews(Integer rating)
    {
        List<MentorReviewResponse> mentorReviewResponses = new ArrayList<>();
        List<Mentor> mentors = mentorRepository.findByOverallRatingInRange(rating, rating+1);
        for(Mentor mentor:mentors)
        {
            Long mentorId = mentor.getId();
            List<Review> mentorReviews = reviewService.getReviewByMentorId(mentorId);
            MentorReviewResponse mentorReviewResponse = MentorReviewResponse.builder()
                    .mentor(mentor)
                    .reviews(mentorReviews)
                    .build();
            mentorReviewResponses.add(mentorReviewResponse);
        }

        return mentorReviewResponses;
    }

    public List<MentorReviewResponse> getAllMentorsWithReviews()
    {
        List<MentorReviewResponse> mentorReviewResponses = new ArrayList<>();
        List<Mentor> mentors = mentorRepository.findAll();
        for(Mentor mentor:mentors)
        {
            Long mentorId = mentor.getId();
            List<Review> mentorReviews = reviewService.getReviewByMentorId(mentorId);
            MentorReviewResponse mentorReviewResponse = MentorReviewResponse.builder()
                    .mentor(mentor)
                    .reviews(mentorReviews)
                    .build();
            mentorReviewResponses.add(mentorReviewResponse);
        }

        return mentorReviewResponses;
    }
}
