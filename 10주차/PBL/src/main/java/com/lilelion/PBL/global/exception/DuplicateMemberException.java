package com.lilelion.PBL.global.exception;

/**
 * 이미 존재하는 이름으로 멤버를 등록하려고 할 때 발생하는 예외.
 */
public class DuplicateMemberException extends RuntimeException {
    public DuplicateMemberException(String message) {
        super(message);
    }
}
