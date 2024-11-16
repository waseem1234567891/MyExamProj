package com.example.NewExamDemoProj1.user_management.services.repository;

import com.example.NewExamDemoProj1.user_management.services.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
