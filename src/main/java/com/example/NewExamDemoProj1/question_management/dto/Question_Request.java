package com.example.NewExamDemoProj1.question_management.dto;

import com.example.NewExamDemoProj1.question_management.entity.Exam;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Setter
@Getter
public class Question_Request {

    private String content;  // Question content
    private String type;     // SINGLE_CHOICE, TRUE_FALSE, MULTIPLE_CHOICE
    private String difficulty;
    private String topic;
    private String option_1;
    private String option_2;
    private String option_3;
    private String option_4;
    private String correct_option;
    @NotNull
    private Long examId;
}



