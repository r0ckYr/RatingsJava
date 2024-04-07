package com.example.rating.service;

import com.example.rating.model.RecommendStudent;
import com.example.rating.repository.RecommendStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecommendStudentService {
    @Autowired
    private RecommendStudentRepository recommendStudentRepository;

    public RecommendStudent createRecommendStudent(RecommendStudent recommendStudent) {
        return recommendStudentRepository.save(recommendStudent);
    }

    public List<RecommendStudent> getAllRecommendStudents() {
        return recommendStudentRepository.findAll();
    }

    public Optional<RecommendStudent> getRecommendStudentById(Long recommendStudentId) {
        return recommendStudentRepository.findById(recommendStudentId);
    }
}
