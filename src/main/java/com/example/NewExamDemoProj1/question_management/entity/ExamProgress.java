package com.example.NewExamDemoProj1.question_management.entity;

import com.example.NewExamDemoProj1.user_management.entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    @OneToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "id")
    @JsonBackReference
    private Exam exam;


    @ElementCollection
    @CollectionTable(name = "user_answers_progress", joinColumns = @JoinColumn(name = "examprogress_id"))
    @MapKeyColumn(name = "question_id") // Column for the Map's key
    @Column(name = "user_answer")       // Column for the Map's value
    private Map<Long, String> userAnswers; // JSON string of selected answers

    private int currentPage;



    // Getters and setters
}

