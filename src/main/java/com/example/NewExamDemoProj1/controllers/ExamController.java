package com.example.NewExamDemoProj1.controllers;


import com.example.NewExamDemoProj1.question_management.dto.ResultRequest;
import com.example.NewExamDemoProj1.question_management.entity.Exam;
import com.example.NewExamDemoProj1.question_management.entity.Question;
import com.example.NewExamDemoProj1.question_management.entity.Result;
import com.example.NewExamDemoProj1.services.ExamService;
import com.example.NewExamDemoProj1.services.QuestionService;
import com.example.NewExamDemoProj1.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class ExamController {

    @Autowired
    ExamService examService;
    @Autowired
    QuestionService questionService;
    @Autowired
    ResultService resultService;
    //get all exams
    @GetMapping("/exams")
    public Optional<List<Exam>> getAllExam(Long id)
    {
        return examService.getAllExams();
    }
    //get questions for an exam by id
    @GetMapping("/exams/{examid}")
    public ResponseEntity<Page<Question>> getQuestionByExamId(@PathVariable Long examid, @RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "1") int size){
        Page<Question> questions=questionService.getQuestionByExamId(examid,page,size);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    // Create a new result
    @PostMapping("/result")
    public ResponseEntity<Result> createResult(@RequestBody ResultRequest result) {
        Result savedResult = resultService.saveResult(result);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedResult);
    }

    //getting all questions from an exam using exam id
    @GetMapping("/examallquestions/{id}")
    public List<Question> getAllQuestionsOfAnExam(@PathVariable Long id)
    {
        List<Question> allQuestionsByExamId = examService.getAllQuestionsByExamId(id);
        return  allQuestionsByExamId;
    }
}
