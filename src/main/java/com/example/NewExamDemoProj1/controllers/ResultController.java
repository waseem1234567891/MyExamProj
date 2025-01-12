package com.example.NewExamDemoProj1.controllers;

import com.example.NewExamDemoProj1.question_management.dto.ResultRequest;
import com.example.NewExamDemoProj1.question_management.entity.Result;
import com.example.NewExamDemoProj1.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users/result")
public class ResultController {

    @Autowired
    ResultService resultService;
    @PostMapping("/save")
    public Result saveResult(@RequestBody ResultRequest resultRequest)
    {
         return resultService.saveResult(resultRequest);
    }
    @GetMapping("/getresult/{id}")
    public Optional<Result> getResultById(@PathVariable Long id)
    {
        return resultService.getResult(id);
    }
    //calculate and save result
    @PostMapping("/calAndSaveResult/{id}")
    public Long calculateAndSaveResult(@PathVariable Long id)
    {
       return resultService.calculateAndSaveResult(id);
    }

    // Endpoint to get average score for a particular exam
    @GetMapping("/average-score/{examId}")
    public Double getAverageScoreByExamId(@PathVariable Long examId) {
        return resultService.getAverageScoreByExamId(examId);
    }

}
