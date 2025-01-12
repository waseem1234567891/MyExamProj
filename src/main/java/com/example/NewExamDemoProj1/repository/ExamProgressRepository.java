package com.example.NewExamDemoProj1.repository;

import com.example.NewExamDemoProj1.question_management.entity.ExamProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ExamProgressRepository extends JpaRepository<ExamProgress, Long> {
    Optional<ExamProgress> findByUserIdAndExamId(Long userId, Long examId);



}

