package com.example.NewExamDemoProj1.services;


import com.example.NewExamDemoProj1.question_management.dto.ResultRequest;
import com.example.NewExamDemoProj1.question_management.entity.Exam;
import com.example.NewExamDemoProj1.question_management.entity.ExamProgress;
import com.example.NewExamDemoProj1.question_management.entity.Question;
import com.example.NewExamDemoProj1.question_management.entity.Result;
import com.example.NewExamDemoProj1.repository.ResultRepository;
import com.example.NewExamDemoProj1.user_management.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ResultService {



    @Autowired
    private UserService userService;
    @Autowired
    private ExamService examService;
    @Autowired
    private ExamProgressService examProgressService;
    @Autowired
    private ResultRepository resultRepository;

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


    public Long calculateAndSaveResult(Long examProgressId)
    {
       ExamProgress examProgress= examProgressService.getProgressById(examProgressId).orElseThrow(()->new RuntimeException("Exam Progress not found"));

       Long examId=(examProgress.getExam()).getId();
       List<Question> questions=examService.getAllQuestionsByExamId(examId);
       int totalQuestions= questions.size();
       int correctAnswer=0;
       Map<Long, String> userAllAnswers=examProgress.getUserAnswers();
        // Compare user answers with correct answers
       for (Question question:questions)
       {
           String userAnswer=examProgress.getUserAnswers().get(question.getId());
           if(userAnswer!=null&&userAnswer.equals(question.getCorrect_option()))
           {
               correctAnswer++;
           }
       }
        // Calculate score (optional: as a percentage)
        double score =  ((double) correctAnswer / totalQuestions )* 100;
       double passThreshold = 50; // Define a pass threshold (e.g., 50%)
        boolean isPassed = score >= passThreshold;
        Result result=new Result();
       result.setTotalQuestions(totalQuestions);
       result.setScore(score);
       result.setUser(examProgress.getUser());
       result.setCorrectAnswers(correctAnswer);
       result.setAttemptDate(LocalDateTime.now());
       result.setExam(examProgress.getExam());
       result.setPassed(isPassed);
       result.setUserAnswers(new HashMap<>(userAllAnswers));
        Result save = resultRepository.save(result);
        return save.getId();
    }

    public List<Result> getAllResults() {
       return resultRepository.findAll();
    }

    public Optional<Result> getResult(Long id) {

            return resultRepository.findById(id);

    }
  //counting average
    public Double getAverageScoreByExamId(Long examId) {
        return resultRepository.findAverageScoreByExamId(examId);
    }
}
