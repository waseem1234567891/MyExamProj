package com.example.NewExamDemoProj1.repository;



import com.example.NewExamDemoProj1.question_management.entity.Result;
import com.example.NewExamDemoProj1.user_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {


}

