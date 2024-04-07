package com.example.rating.controller;

import com.example.rating.dto.RecommendRequest;
import com.example.rating.model.RecommendStudent;
import com.example.rating.repository.RecommendStudentRepository;
import com.example.rating.service.RecommendStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/recommendation")
public class RecommendStudentController {

    @Autowired
    private RecommendStudentService recommendStudentService;

    @PostMapping("/create")
    public ResponseEntity<RecommendStudent> recommend(@RequestBody RecommendStudent recommendStudent)
    {
        RecommendStudent recommendStudent1 = recommendStudentService.createRecommendStudent(recommendStudent);
        return new ResponseEntity<>(recommendStudent1, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RecommendStudent>> getAllRecommendations()
    {
        return new ResponseEntity<>(recommendStudentService.getAllRecommendStudents(), HttpStatus.OK);
    }

    @GetMapping("/{recommendationID}")
    public ResponseEntity<RecommendStudent> getRecommendationById(@PathVariable long recommendationId)
    {
        Optional<RecommendStudent> recommendStudent = recommendStudentService.getRecommendStudentById(recommendationId);
        return recommendStudent.map(student -> new ResponseEntity<>(student, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
