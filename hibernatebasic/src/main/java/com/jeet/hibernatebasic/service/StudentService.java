package com.jeet.hibernatebasic.service;

import com.jeet.hibernatebasic.dto.StudentDto;
import com.jeet.hibernatebasic.entity.Student;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto dto);
    List<StudentDto> getAllStudents();
    StudentDto getStudentById(Long id);
    StudentDto updateStudent(Long id, StudentDto studentDto);
}
