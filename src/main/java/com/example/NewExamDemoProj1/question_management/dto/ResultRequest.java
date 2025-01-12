package com.example.NewExamDemoProj1.question_management.dto;

import com.example.NewExamDemoProj1.question_management.entity.Exam;
import com.example.NewExamDemoProj1.user_management.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultRequest {




    private Long userId; // Links the result to a specific user.


    private Long examId; // Associated exam.

    private int totalQuestions;

    private int correctAnswers;

    private int incorrectAnswers;

    private double score; // Percentage or raw score.


    private Map<Long, String> userAnswers = new HashMap<>(); // Tracks user answers for each question.

    private boolean isPassed; // To determine if the user passed or failed.

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime attemptDate; // Timestamp for the attempt.
}
