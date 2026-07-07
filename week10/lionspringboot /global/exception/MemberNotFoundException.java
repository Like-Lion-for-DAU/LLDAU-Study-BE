package com.springbootbackend.lionspringboot.global.exception;

/**
 * 멤버를 조회했지만 존재하지 않을 때 던지는 예외.
 *
 * RuntimeException(언체크 예외)을 상속하는 이유:
 *  - 체크 예외(Exception)로 만들면 서비스/컨트롤러 곳곳에서 try-catch나
 *    throws 선언을 강제당해 코드가 지저분해진다.
 *  - Spring의 @Transactional은 기본적으로 "언체크 예외(RuntimeException)"가
 *    터졌을 때만 롤백한다. 체크 예외는 기본적으로 롤백하지 않는다.
 *    → 조회 실패 같은 비즈니스 예외를 RuntimeException으로 두면
 *      트랜잭션 롤백 정책과도 자연스럽게 맞물린다.
 */
public class MemberNotFoundException extends RuntimeException {

    // 메시지를 받아 부모(RuntimeException)의 생성자로 전달.
    // 이 메시지가 나중에 GlobalExceptionHandler에서 e.getMessage()로 추출된다.
    public MemberNotFoundException(String message) {
        super(message);
    }
}
