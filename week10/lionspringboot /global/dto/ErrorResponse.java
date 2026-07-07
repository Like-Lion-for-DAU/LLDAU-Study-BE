package com.springbootbackend.lionspringboot.global.dto;

import java.time.LocalDateTime;

/**
 * 모든 예외 발생 시 클라이언트에게 내려주는 "일관된" 에러 응답 형식.
 *
 * record를 쓴 이유:
 *  - 에러 응답은 한 번 만들어지면 값이 바뀌지 않는 불변 데이터다.
 *  - record는 필드 선언만으로 생성자/getter/equals/hashCode/toString을
 *    자동 생성해줘서 DTO에 딱 맞는다.
 *
 * 필드 설명:
 *  - status    : HTTP 상태 코드 숫자 (404, 409, 400, 500 ...)
 *  - error     : 상태 코드의 의미 ("Not Found", "Conflict" ...)
 *  - message   : 개발자가 던진 구체적 메시지 ("id=5인 멤버가 없습니다")
 *  - timestamp : 에러 발생 시각 (디버깅/로그 추적용)
 */
public record ErrorResponse(
        int status,
        String error,
        String message,
        LocalDateTime timestamp
) {
    /**
     * 정적 팩토리 메서드.
     * timestamp는 매번 "지금 시각"으로 자동 채우고 싶으므로,
     * 호출부에서 넘기지 않도록 여기서 LocalDateTime.now()를 채운다.
     * → 9주차에 배운 from() 패턴과 같은 맥락(생성 로직 캡슐화).
     */
    public static ErrorResponse of(int status, String error, String message) {
        return new ErrorResponse(status, error, message, LocalDateTime.now());
    }
}
