package com.jeet.hibernatebasic.controller;

import com.jeet.hibernatebasic.dto.StudentDto;
import com.jeet.hibernatebasic.entity.Student;
import com.jeet.hibernatebasic.response.ApiResponse;
import com.jeet.hibernatebasic.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class studentController {
    private final StudentService studentService;

    public studentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student")
    public ApiResponse<StudentDto> addStudent(@RequestBody StudentDto studentDto){
        StudentDto saved = studentService.createStudent(studentDto);
        return new ApiResponse<>(
                "Student created successfully",
                saved,
                true,
                HttpStatus.OK.value()
        );
    }

    @GetMapping("/students")
    public ApiResponse<List<StudentDto>> getStudents() {
        List<StudentDto> students = studentService.getAllStudents();
        return new ApiResponse<>("Students retrieved successfully", students, true,HttpStatus.OK.value());
    }

    @GetMapping("/student/{id}")
    public ApiResponse<StudentDto> getStudentById(@PathVariable Long id) {
        StudentDto student = studentService.getStudentById(id);
        return new ApiResponse<>("Student retrieved successfully", student, true, HttpStatus.OK.value());
    }
    @PutMapping("/student/{id}")
    public ApiResponse<StudentDto> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        StudentDto student = studentService.updateStudent(id,studentDto);
        return new ApiResponse<>("Student update successfully", student, true, HttpStatus.OK.value());
    }
    @PutMapping("/student/{id}")
    public StudentDto updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        return studentService.updateStudent(id,studentDto); // Placeholder return statement
    }
}
