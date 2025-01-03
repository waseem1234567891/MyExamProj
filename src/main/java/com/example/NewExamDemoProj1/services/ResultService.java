package com.example.NewExamDemoProj1.services;


import com.example.NewExamDemoProj1.question_management.dto.ResultRequest;
import com.example.NewExamDemoProj1.question_management.entity.Exam;
import com.example.NewExamDemoProj1.question_management.entity.Result;
import com.example.NewExamDemoProj1.repository.ResultRepository;
import com.example.NewExamDemoProj1.user_management.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultService {

    private final ResultRepository resultRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private ExamService examService;

    @Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;

    }

    // Save the result
    public Result saveResult(ResultRequest result) {
        Result result1=new Result();
        Optional<Exam> exam=examService.displayAnExam(result.getExamId());
        result1.setExam(exam.get());
        result1.setPassed(result.isPassed());
        Optional<User> user=userService.getUserById(result.getUserId());
        result1.setUser(user.get());
        result1.setScore(result.getScore());
        result1.setAttemptDate(result.getAttemptDate());
        result1.setUserAnswers(result.getUserAnswers());
        result1.setTotalQuestions(result.getTotalQuestions());

        return resultRepository.save(result1);
    }

    // Calculate and set the score for a result
    public void calculateAndSaveResult(Result result) {
//        int correctAnswers = result.getCorrectAnswers();
//        int totalQuestions = result.getTotalQuestions();
//        int score = (int) (((double) correctAnswers / totalQuestions) * 100);  // Calculate score
//
//        result.setScore(score);
//        result.setPassed(score >= 50);  // Example: passing score is 50%
       // saveResult(result);
    }

    public List<Result> getAllResults() {
       return resultRepository.findAll();
    }
}
