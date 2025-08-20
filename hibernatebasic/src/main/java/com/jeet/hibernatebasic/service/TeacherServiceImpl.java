package com.jeet.hibernatebasic.service;

import com.jeet.hibernatebasic.dto.TeacherDto;
import com.jeet.hibernatebasic.entity.Teacher;
import com.jeet.hibernatebasic.exception.TeacherNotFoundException;
import com.jeet.hibernatebasic.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{
    private final TeacherRepository teacherRepository;
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
    @Override
    public TeacherDto createTeacher(TeacherDto dto) {
        Teacher teacher = new Teacher();
        teacher.setName(dto.getName());
        teacher.setEmail(dto.getEmail());
        Teacher savedTeacher = teacherRepository.save(teacher);
        return new TeacherDto(savedTeacher.getName(), savedTeacher.getEmail());
    }

    @Override
    public List<TeacherDto> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream()
                .map(teacher -> new TeacherDto(teacher.getName(), teacher.getEmail()))
                .toList();
    }

    @Override
    public TeacherDto getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException(id));
        return new TeacherDto(teacher.getName(), teacher.getEmail());
    }

    @Override
    public TeacherDto updateTeacher(Long id, TeacherDto teacherDto) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException(id));

        // update fields
        teacher.setName(teacherDto.getName());
        teacher.setEmail(teacherDto.getEmail());

        Teacher updatedTeacher = teacherRepository.save(teacher);
        return new TeacherDto(updatedTeacher.getName(), updatedTeacher.getEmail());
    }
}
