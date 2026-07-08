package com.example.demo.class5.global.exception;

public class AssignmentNotFoundException extends RuntimeException {

    public AssignmentNotFoundException(String message) {
        super(message);
    }
}