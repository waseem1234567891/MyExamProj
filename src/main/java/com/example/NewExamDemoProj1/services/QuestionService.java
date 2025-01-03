package com.example.NewExamDemoProj1.services;


import com.example.NewExamDemoProj1.question_management.entity.Exam;
import com.example.NewExamDemoProj1.question_management.entity.Question;
import com.example.NewExamDemoProj1.repository.ExamRepository;
import com.example.NewExamDemoProj1.repository.QuestionRepository;
import com.example.NewExamDemoProj1.utility.ExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    @Autowired
    private ExcelHelper excelHelper;
    @Autowired
    public QuestionService(QuestionRepository questionRepository,ExamRepository examRepository) {
        this.questionRepository = questionRepository;
    }

    // Create a new question
    public Question createQuestion(Question addQuestionRequest) {
        // Link options to the question

        return questionRepository.save(addQuestionRequest);
    }

    // Retrieve all questions
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    //get all question from a exam
    public Page<Question> getQuestionByExamId(Long exam_id,int page,int size)
    {
        Pageable pageable= PageRequest.of(page,size);
        return questionRepository.findByExamId(exam_id,pageable);
    }

    //add question from excel file
    public void saveQuestionsFromExcel(MultipartFile file) {
        List<Question> questions = excelHelper.parseExcelFile(file);
        questionRepository.saveAll(questions);
    }


}
