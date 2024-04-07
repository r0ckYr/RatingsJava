package com.example.rating.repository;

import com.example.rating.model.Mentor;
import com.example.rating.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByMentorId(Long mentorId);
}
