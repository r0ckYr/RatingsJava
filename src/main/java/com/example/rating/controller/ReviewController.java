package com.example.rating.controller;

import com.example.rating.dto.ReviewRequest;
import com.example.rating.model.Mentor;
import com.example.rating.model.Review;
import com.example.rating.model.User;
import com.example.rating.service.MentorService;
import com.example.rating.service.ReviewService;
import com.example.rating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {
    @Autowired
    private  MentorService mentorService;
    @Autowired
    private UserService userService;
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/create")
    public ResponseEntity<String> createReview(@RequestBody ReviewRequest reviewRequest)
    {
        Long mentorId = reviewRequest.getMentorId();
        Long userId = reviewRequest.getUserId();
        String comment = reviewRequest.getComment();
        Optional<Mentor> mentor = mentorService.getMentorById(mentorId);
        if(mentor.isEmpty())
            return new ResponseEntity<>("Mentor Not Found", HttpStatus.BAD_REQUEST);

        Optional<User> user = userService.getUserById(userId);
        if(user.isEmpty())
            return new ResponseEntity<>("User Not Found", HttpStatus.BAD_REQUEST);

        if(comment.length()>50)
            return new ResponseEntity<>("User Not Found", HttpStatus.BAD_REQUEST);

        Review newReview = Review.builder()
                .mentor(mentor.get())
                .user(user.get())
                .comment(comment)
                .build();
        newReview = reviewService.createreview(newReview);

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
