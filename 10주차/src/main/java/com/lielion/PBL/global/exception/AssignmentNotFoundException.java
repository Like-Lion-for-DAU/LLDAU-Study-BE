package com.lielion.PBL.global.exception;

public class AssignmentNotFoundException extends RuntimeException {
    public AssignmentNotFoundException(Long id) {
        super("존재하지 않는 과제입니다. id=" + id);
    }
}
