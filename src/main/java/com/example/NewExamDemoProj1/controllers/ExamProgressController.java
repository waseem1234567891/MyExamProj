package com.example.NewExamDemoProj1.controllers;

import com.example.NewExamDemoProj1.question_management.dto.ExamProgressDto;
import com.example.NewExamDemoProj1.question_management.entity.ExamProgress;
import com.example.NewExamDemoProj1.services.ExamProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/progress")
public class ExamProgressController {

    @Autowired
    private ExamProgressService progressService;

    @PostMapping("/save")
    public ResponseEntity<?> saveProgress(@RequestBody ExamProgressDto dto) {
        progressService.saveProgress(dto.getUserId(), dto.getExamId(), dto.getUserAnswers(), dto.getCurrentPage());
        return ResponseEntity.ok("Progress saved successfully.");
    }
    @GetMapping("/get")
    public Optional<ExamProgress> getProgress(@RequestParam Long userId, @RequestParam Long examId) {
        return progressService.getProgress(userId, examId);

    }
    @DeleteMapping("/exam-progress")
    public ResponseEntity<Void> deleteProgress(@RequestParam Long userId, @RequestParam Long examId) {
        try {
            progressService.deleteProgress(userId, examId); // Service to handle deletion
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}



