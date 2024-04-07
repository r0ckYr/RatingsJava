package com.example.rating.repository;

import com.example.rating.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MentorRepository extends JpaRepository<Mentor, Long> {

    @Query("SELECT m FROM Mentor m WHERE m.overallRating >= :minRating AND m.overallRating < :maxRating")
    List<Mentor> findByOverallRatingInRange(@Param("minRating") int minRating, @Param("maxRating") int maxRating);
}
