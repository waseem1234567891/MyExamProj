package com.example.NewExamDemoProj1.question_management.entity;



import com.example.NewExamDemoProj1.user_management.entity.User; // Assuming User entity exists
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "id")
    @JsonBackReference
    private Exam exam;

    private int totalQuestions;

    private int correctAnswers;

    private int incorrectAnswers;

    private double score; // Percentage or raw score.


    @ElementCollection
    @CollectionTable(name = "user_answers", joinColumns = @JoinColumn(name = "result_id"))
    @MapKeyColumn(name = "question_id") // Column for the Map's key
    @Column(name = "user_answer")       // Column for the Map's value
    private Map<Long, String> userAnswers = new HashMap<>(); // Tracks user answers for each question.

    private boolean isPassed; // To determine if the user passed or failed.

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime attemptDate; // Timestamp for the attempt.
}



