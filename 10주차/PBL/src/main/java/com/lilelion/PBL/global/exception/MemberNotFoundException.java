package com.lilelion.PBL.global.exception;

/**
 * 멤버를 찾을 수 없을 때 발생하는 예외.
 * Unchecked Exception(RuntimeException)으로 만들어
 * @Transactional의 기본 롤백 정책과 자연스럽게 연동되도록 한다.
 */
public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(String message) {
        super(message);
    }
}
