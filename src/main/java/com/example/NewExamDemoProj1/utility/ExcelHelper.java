package com.example.NewExamDemoProj1.utility;

import com.example.NewExamDemoProj1.question_management.entity.Exam;
import com.example.NewExamDemoProj1.question_management.entity.Question;
import com.example.NewExamDemoProj1.repository.ExamRepository;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ExcelHelper {

    @Autowired
    private ExamRepository examRepository; // Non-static field for dependency injection

    public List<Question> parseExcelFile(MultipartFile file) {
        List<Question> questions = new ArrayList<>();
        try {
            InputStream is = file.getInputStream();
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0); // Assuming first sheet

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Skip header row

                Question question = new Question();
                question.setContent(row.getCell(0).getStringCellValue());
                question.setType(row.getCell(1).getStringCellValue());
                question.setDifficulty(row.getCell(2).getStringCellValue());
                question.setTopic(row.getCell(3).getStringCellValue());

                // Fetch Exam entity based on Exam ID
                Long examId = (long) row.getCell(9).getNumericCellValue();
                Exam exam = examRepository.findById(examId)
                        .orElseThrow(() -> new RuntimeException("Exam not found with ID: " + examId));
                question.setExam(exam);

                if ("MCQ".equalsIgnoreCase(question.getType())) {
                    question.setOption_1(row.getCell(4).getStringCellValue());
                    question.setOption_2(row.getCell(5).getStringCellValue());
                    question.setOption_3(row.getCell(6).getStringCellValue());
                    question.setOption_4(row.getCell(7).getStringCellValue());
                }else if ("TF".equalsIgnoreCase(question.getType()))
                {
                    question.setOption_1(row.getCell(4).getStringCellValue());
                    question.setOption_2(row.getCell(5).getStringCellValue());
                }

                question.setCorrect_option(row.getCell(8).getStringCellValue());
                questions.add(question);
            }

            workbook.close();
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse Excel file: " + e.getMessage());
        }
        return questions;
    }
}
