package com.jeet.hibernatebasic.controller;

import com.jeet.hibernatebasic.dto.StudentDto;
import com.jeet.hibernatebasic.entity.Student;
import com.jeet.hibernatebasic.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class studentController {
    private final StudentService studentService;

    public studentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student addStudent(@RequestBody StudentDto studentDto){
        return studentService.createStudent(studentDto);
    }

    @GetMapping
    public List<StudentDto> getStudents() {
        return studentService.getAllStudents();
    }
}
