package com.example.NewExamDemoProj1.services;

import com.example.NewExamDemoProj1.question_management.entity.ExamProgress;
import com.example.NewExamDemoProj1.repository.ExamProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Service
public class ExamProgressService {

    @Autowired
    private ExamProgressRepository repository;

    public ExamProgress saveProgress(Long userId, Long examId,  Map<Long, String> selectedOptions, int currentPage) {
        ExamProgress progress = repository.findByUserIdAndExamId(userId, examId)
                .orElse(new ExamProgress());

        progress.setUserId(userId);
        progress.setExamId(examId);
        progress.setUserAnswers(selectedOptions);
        progress.setCurrentPage(currentPage);


        return repository.save(progress);
    }

    public Optional<ExamProgress> getProgress(Long userId, Long examId) {
        return repository.findByUserIdAndExamId(userId, examId);
    }
    public void deleteProgress(Long userId, Long examId) {
        repository.deleteByUserIdAndExamId(userId, examId); // Delete progress in DB
    }

   // public void deleteProgress()
}

