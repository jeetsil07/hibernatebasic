package com.jeet.hibernatebasic.service;

import com.jeet.hibernatebasic.dto.StudentDto;
import com.jeet.hibernatebasic.entity.Student;
import com.jeet.hibernatebasic.exception.StudentNotFoundException;
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
    public StudentDto createStudent(StudentDto studentDto) {
        Student st = new Student();
        st.setName(studentDto.getName());
        st.setEmail(studentDto.getEmail());
        st.setRoll(studentDto.getRoll());
        Student s = studentRepository.save(st);
        return new StudentDto(s.getName(), s.getEmail(), s.getRoll());
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();

        // Map Student -> StudentDto
        return students.stream()
                .map(student -> new StudentDto(
                        student.getName(),
                        student.getEmail(),
                        student.getRoll()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        return new StudentDto(student.getName(), student.getEmail(), student.getRoll());
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
            Student student = studentRepository.findById(id)
                    .orElseThrow(() -> new StudentNotFoundException(id));

            // update fields
            student.setName(studentDto.getName());
            student.setEmail(studentDto.getEmail());
            student.setRoll(studentDto.getRoll());

            Student updated = studentRepository.save(student);
            return new StudentDto(updated.getName(), updated.getEmail(),
                        updated.getRoll());
    }
}
