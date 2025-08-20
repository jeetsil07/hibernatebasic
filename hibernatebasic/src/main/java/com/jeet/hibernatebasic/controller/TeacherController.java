package com.jeet.hibernatebasic.controller;

import com.jeet.hibernatebasic.dto.TeacherDto;
import com.jeet.hibernatebasic.response.ApiResponse;
import com.jeet.hibernatebasic.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @PostMapping("/teacher")
    public ApiResponse<TeacherDto> addTeacher(@RequestBody TeacherDto teacherDto) {
        TeacherDto savedTeacher = teacherService.createTeacher(teacherDto);
        return new ApiResponse<>(
                "Teacher created successfully",
                savedTeacher,
                true,
                HttpStatus.OK.value()
        );
    }

    @GetMapping("/teachers")
    public ApiResponse<List<TeacherDto>> getAllTeachers() {
        List<TeacherDto> teachers = teacherService.getAllTeachers();
        return new ApiResponse<>(
                "Teachers retrieved successfully",
                teachers,
                true,
                HttpStatus.OK.value()
        );
    }

    @GetMapping("/teacher/{id}")
    public ApiResponse<TeacherDto> getTeacherById(@PathVariable Long id) {
         TeacherDto teacher = teacherService.getTeacherById(id);
         return new ApiResponse<>(
                 "Teacher retrieved successfully",
                 teacher,
                 true,
                 HttpStatus.OK.value()
         );
    }

    @PutMapping("/teacher/{id}")
    public ApiResponse<TeacherDto> updateTeacher(@PathVariable Long id, @RequestBody TeacherDto teacherDto) {
        TeacherDto updatedTeacher = teacherService.updateTeacher(id, teacherDto);
        return new ApiResponse<>(
                "Teacher updated successfully",
                updatedTeacher,
                true,
                HttpStatus.OK.value()
        );
    }
}
