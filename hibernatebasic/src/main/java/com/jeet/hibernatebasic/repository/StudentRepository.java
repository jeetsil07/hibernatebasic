package com.jeet.hibernatebasic.repository;

import com.jeet.hibernatebasic.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
