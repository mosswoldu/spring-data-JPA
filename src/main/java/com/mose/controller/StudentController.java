//package com.mose.controller;
//
//import com.mose.model.Student;
//import com.mose.service.StudentService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/student")
//@RequiredArgsConstructor
//public class StudentController {
//    private  final StudentService studentService;
//    @PostMapping
//    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
//        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.OK);
//
//    }
//}
