package com.springbootbackend.lionspringboot.global.exception;

/**
 * 멤버 이름이 이미 존재할 때(중복 등록 시도) 던지는 예외.
 *
 * 9주차까지는 서비스에서 null을 반환하고 컨트롤러에서
 * "if (member == null) return 409" 식으로 처리했다.
 * 10주차부터는 이 예외를 던지고, GlobalExceptionHandler가
 * 409 Conflict로 변환하도록 책임을 넘긴다.
 */
public class DuplicateMemberException extends RuntimeException {

    public DuplicateMemberException(String message) {
        super(message);
    }
}
