package com.example.NewExamDemoProj1.services;

import com.example.NewExamDemoProj1.question_management.entity.Exam;
import com.example.NewExamDemoProj1.question_management.entity.ExamProgress;
import com.example.NewExamDemoProj1.repository.ExamProgressRepository;
import com.example.NewExamDemoProj1.user_management.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ExamProgressService {

    @Autowired
    private ExamProgressRepository examProgressRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ExamService examService;

    public ExamProgress saveProgress(Long userId, Long examId,  Map<Long, String> selectedOptions, int currentPage) {
        ExamProgress progress = examProgressRepository.findByUserIdAndExamId(userId, examId)
                .orElse(new ExamProgress());
        Optional<User> user=userService.getUserById(userId);
        progress.setUser(user.get());
        Optional<Exam> exam=examService.displayAnExam(examId);
        progress.setExam(exam.get());
        progress.setUserAnswers(selectedOptions);
        progress.setCurrentPage(currentPage);


        return examProgressRepository.save(progress);
    }

    public Optional<ExamProgress> getProgress(Long userId, Long examId) {
        return examProgressRepository.findByUserIdAndExamId(userId, examId);
    }
    //delete a progress
    public void deleteProgressByProgressId(Long id) {
        if(examProgressRepository.existsById(id))
        {
            examProgressRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("ExamProgress with ID " + id + " does not exist.");
        }
    }

    public Optional<ExamProgress> getProgressById(Long examProgressId) {
        return examProgressRepository.findById(examProgressId);
    }

    // public void deleteProgress()
}

