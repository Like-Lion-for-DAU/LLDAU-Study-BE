package com.example.demo.global.exception;

public class DuplicateMemberNameException extends RuntimeException {
    public DuplicateMemberNameException(String message) {
        super(message);
    }
}
