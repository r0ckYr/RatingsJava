package com.example.rating.controller;


import com.example.rating.dto.MentorReviewResponse;
import com.example.rating.dto.RateRequest;
import com.example.rating.dto.ReviewRequest;
import com.example.rating.model.Mentor;
import com.example.rating.model.User;
import com.example.rating.service.MentorService;
import com.example.rating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/mentor")
public class MentorController {

    @Autowired
    private MentorService mentorService;
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Mentor> createMentor(@RequestBody Mentor newMentor){
        Mentor mentor = mentorService.createMentor(newMentor);
        return new ResponseEntity<>(mentor, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MentorReviewResponse>> getAllUsers(@RequestParam(name="rating", required=false) Integer rating)
    {
        if(rating!=null) {
            if(rating>5 || rating<0)
            {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(mentorService.getMentorsWithReviews(rating), HttpStatus.OK);
        }
        return new ResponseEntity<>(mentorService.getAllMentorsWithReviews(), HttpStatus.OK);
    }

    @PostMapping("/rate")
    public ResponseEntity<String> rateMentor(@RequestBody RateRequest request)
    {
        Long mentorId = request.getMentorId();
        int rating = request.getRating();

        Optional<Mentor> mentor = mentorService.getMentorById(mentorId);
        if(mentor.isEmpty())
            return new ResponseEntity<>("Mentor Not Found", HttpStatus.NOT_FOUND);

        mentorService.rateMentor(mentor.get(), rating);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
