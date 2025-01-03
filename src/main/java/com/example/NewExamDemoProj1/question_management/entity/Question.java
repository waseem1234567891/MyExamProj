package com.example.NewExamDemoProj1.question_management.entity;




import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;  // Question content
    private String type;     // SINGLE_CHOICE, TRUE_FALSE, MULTIPLE_CHOICE
    private String difficulty;
    private String topic;
    private String option_1;
    private String option_2;
    private String option_3;
    private String option_4;
    private String correct_option;
    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    @JsonBackReference
    private Exam exam;





}
