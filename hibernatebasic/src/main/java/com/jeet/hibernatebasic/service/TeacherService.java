package com.jeet.hibernatebasic.service;

import com.jeet.hibernatebasic.dto.TeacherDto;

import java.util.List;

public interface TeacherService {
    TeacherDto createTeacher(TeacherDto dto);
    List<TeacherDto> getAllTeachers();
    TeacherDto getTeacherById(Long id);
    TeacherDto updateTeacher(Long id, TeacherDto teacherDto);
}
