package com.example.rating.repository;

import com.example.rating.model.RecommendStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendStudentRepository extends JpaRepository<RecommendStudent, Long> {
}
