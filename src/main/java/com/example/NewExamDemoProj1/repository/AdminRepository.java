package com.example.NewExamDemoProj1.repository;

import com.example.NewExamDemoProj1.adminManagement.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdminUser,Long> {

    Optional<AdminUser> findByUserName(String userName);
}
