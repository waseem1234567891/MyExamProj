package com.example.NewExamDemoProj1.controllers;


import com.example.NewExamDemoProj1.adminManagement.dto.AdminLoginRequest;
import com.example.NewExamDemoProj1.adminManagement.entity.AdminUser;
import com.example.NewExamDemoProj1.services.AdminService;
import com.example.NewExamDemoProj1.user_management.dto.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

 @Autowired
 AdminService adminService;
 @PostMapping("/login")
 public ResponseEntity<ApiResponse>  loginAdmin(@Valid @RequestBody AdminLoginRequest adminLoginRequest)
 {
AdminUser adminUser=adminService.login_admin(adminLoginRequest);
ApiResponse apiResponse=new ApiResponse("success","Admin is login successfully");
  return  ResponseEntity.status(HttpStatus.FOUND).body(apiResponse);
 }
}
