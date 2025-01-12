package com.example.NewExamDemoProj1.repository;



import com.example.NewExamDemoProj1.question_management.entity.Result;
import com.example.NewExamDemoProj1.user_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    // Custom query to calculate average score for a specific exam
    @Query("SELECT AVG(r.score) FROM Result r WHERE r.exam.id = :examId")
    Double findAverageScoreByExamId(@Param("examId") Long examId);
}

