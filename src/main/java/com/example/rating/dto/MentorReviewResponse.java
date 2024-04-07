package com.example.rating.dto;

import com.example.rating.model.Mentor;
import com.example.rating.model.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MentorReviewResponse {
    private Mentor mentor;
    private List<Review> reviews;
}
