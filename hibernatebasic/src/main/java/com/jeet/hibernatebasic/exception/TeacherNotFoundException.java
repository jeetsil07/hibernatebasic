package com.jeet.hibernatebasic.exception;

public class TeacherNotFoundException extends RuntimeException {
    public TeacherNotFoundException(Long id) {
        super("Teacher not found with id: " + id);
    }
}
