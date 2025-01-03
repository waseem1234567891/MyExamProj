package com.example.NewExamDemoProj1.services;


import com.example.NewExamDemoProj1.question_management.entity.Exam;
import com.example.NewExamDemoProj1.question_management.entity.Question;
import com.example.NewExamDemoProj1.repository.ExamRepository;
import com.example.NewExamDemoProj1.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

    private final ExamRepository examRepository;
    private final QuestionRepository questionRepository;

    @Autowired
    public ExamService(ExamRepository examRepository, QuestionRepository questionRepository) {
        this.examRepository = examRepository;
        this.questionRepository = questionRepository;
    }

    // Create a new exam
    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }
    //display an exam by Exam id
    public Optional<Exam> displayAnExam(Long id)
    {
        return examRepository.findById(id);
    }
    //display all exams
    public Optional<List<Exam>> getAllExams()
    {
        return Optional.of(examRepository.findAll());
    }
    //display all question of an exam search by exam id



    // Add questions to an existing exam
    public void addQuestionsToExam(Long examId, List<Long> questionIds) {
        Exam exam = examRepository.findById(examId).orElseThrow();
        List<Question> questions = questionRepository.findAllById(questionIds);
        exam.setQuestions(questions);
        examRepository.save(exam);
    }
}
