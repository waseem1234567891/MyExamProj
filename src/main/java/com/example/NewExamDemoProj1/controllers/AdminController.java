package com.example.NewExamDemoProj1.controllers;


import com.example.NewExamDemoProj1.adminManagement.dto.AdminLoginRequest;
import com.example.NewExamDemoProj1.adminManagement.entity.AdminUser;
import com.example.NewExamDemoProj1.services.AdminService;
import com.example.NewExamDemoProj1.services.QuestionService;
import com.example.NewExamDemoProj1.user_management.dto.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

 @Autowired
 AdminService adminService;
 @Autowired
 QuestionService questionService;
 @PostMapping("/login")
 public ResponseEntity<ApiResponse>  loginAdmin(@Valid @RequestBody AdminLoginRequest adminLoginRequest)
 {
AdminUser adminUser=adminService.login_admin(adminLoginRequest);
ApiResponse apiResponse=new ApiResponse(true, "success","Admin is login successfully");
  return  ResponseEntity.status(HttpStatus.OK).body(apiResponse);
 }

 //add questions from excel file
 @PostMapping("/upload")
 public ResponseEntity<String> addQuestiosFromExcelFile(MultipartFile file)
 {
  questionService.saveQuestionsFromExcel(file);
  String response="questions uploaded";
  return ResponseEntity.status(HttpStatus.OK).body(response);
 }
}
