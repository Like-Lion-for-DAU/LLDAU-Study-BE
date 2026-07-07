package com.lilelion.PBL.global.exception;

/**
 * 과제를 찾을 수 없을 때 발생하는 예외.
 */
public class AssignmentNotFoundException extends RuntimeException {
    public AssignmentNotFoundException(String message) {
        super(message);
    }
}
