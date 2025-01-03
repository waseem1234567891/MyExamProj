package com.example.NewExamDemoProj1.controllers;



import com.example.NewExamDemoProj1.question_management.entity.Question;

import com.example.NewExamDemoProj1.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;


//    @GetMapping("/exam/{examid}")
//    public ResponseEntity<Page<Question>> getQuestionByExamId(@PathVariable Long examid,@RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "10") int size){
//        Page<Question> questions=questionService.getQuestionByExamId(examid,page,size);
//        return new ResponseEntity<>(questions,HttpStatus.OK);
//    }


}


