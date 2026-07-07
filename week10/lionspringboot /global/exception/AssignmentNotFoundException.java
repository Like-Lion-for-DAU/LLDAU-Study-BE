package com.springbootbackend.lionspringboot.global.exception;

/**
 * 과제(Assignment)를 조회했지만 존재하지 않을 때 던지는 예외.
 * 구조는 MemberNotFoundException과 동일 — 도메인만 다르다.
 * 예외 클래스를 도메인별로 나누면, 나중에 예외별로
 * 다른 상태 코드/메시지를 매핑하기 쉬워진다.
 */
public class AssignmentNotFoundException extends RuntimeException {

    public AssignmentNotFoundException(String message) {
        super(message);
    }
}
