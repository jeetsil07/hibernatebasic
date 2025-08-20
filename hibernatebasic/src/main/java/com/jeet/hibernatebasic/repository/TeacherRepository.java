package com.jeet.hibernatebasic.repository;

import com.jeet.hibernatebasic.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
