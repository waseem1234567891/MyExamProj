package com.example.NewExamDemoProj1.question_management.dto;

import com.example.NewExamDemoProj1.question_management.entity.ExamProgress;
import lombok.*;

import java.util.Map;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamProgressDto {
    private Long userId;
    private Long examId;
    private Map<Long, String> userAnswers;
    private int currentPage;


    public ExamProgressDto(ExamProgress progress) {
    }
}