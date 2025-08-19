package com.jeet.hibernatebasic.service;

import com.jeet.hibernatebasic.dto.StudentDto;
import com.jeet.hibernatebasic.entity.Student;
import com.jeet.hibernatebasic.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(StudentDto studentDto){
        Student st = new Student();
        st.setName(studentDto.getName());
        st.setEmail(studentDto.getEmail());
        st.setRoll(studentDto.getRoll());
        return studentRepository.save(st);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(s -> new StudentDto(s.getName(), s.getEmail(), s.getRoll()))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(s -> new StudentDto(s.getName(), s.getEmail(), s.getRoll()))
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }
}
