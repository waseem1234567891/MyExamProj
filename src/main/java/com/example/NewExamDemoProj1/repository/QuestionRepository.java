package com.example.NewExamDemoProj1.repository;


import com.example.NewExamDemoProj1.question_management.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Page<Question> findByExamId(Long exam_id, Pageable pageable);
}
