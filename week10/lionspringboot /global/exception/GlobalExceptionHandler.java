package com.springbootbackend.lionspringboot.global.exception;

import com.springbootbackend.lionspringboot.global.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * [전역 예외 처리기]
 *
 * @RestControllerAdvice
 *  = @ControllerAdvice + @ResponseBody
 *  - @ControllerAdvice : 모든 @RestController에서 발생한 예외를
 *                        한 곳에서 가로채(intercept) 처리하게 해준다.
 *  - @ResponseBody     : 반환한 객체(ErrorResponse)를 JSON으로 직렬화해
 *                        HTTP 응답 본문에 실어 보낸다.
 *
 * 이게 왜 좋은가?
 *  - 9주차 컨트롤러는 메서드마다 "if (x == null) return notFound()"처럼
 *    예외 처리 코드가 흩어져 있었다.
 *  - 이제 컨트롤러는 "정상 흐름"만 작성하고,
 *    예외가 터지면 여기로 모여 일관된 형식(ErrorResponse)으로 변환된다.
 *    → 관심사의 분리(SoC): 컨트롤러는 성공, Advice는 실패 담당.
 *
 * @ExceptionHandler(X.class)
 *  - X 타입의 예외가 던져지면 이 메서드가 실행된다.
 *  - 메서드 파라미터로 그 예외 객체를 받아 메시지 등을 꺼낼 수 있다.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 멤버 조회 실패 → 404 Not Found
    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMemberNotFound(MemberNotFoundException e) {
        ErrorResponse body = ErrorResponse.of(
                HttpStatus.NOT_FOUND.value(),        // 404
                HttpStatus.NOT_FOUND.getReasonPhrase(), // "Not Found"
                e.getMessage()                        // 서비스에서 던진 메시지
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    // 과제 조회 실패 → 404 Not Found
    @ExceptionHandler(AssignmentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAssignmentNotFound(AssignmentNotFoundException e) {
        ErrorResponse body = ErrorResponse.of(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    // 멤버 이름 중복 → 409 Conflict
    // (요청 자체는 문법상 정상이지만, 현재 상태와 충돌한다는 의미)
    @ExceptionHandler(DuplicateMemberException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateMember(DuplicateMemberException e) {
        ErrorResponse body = ErrorResponse.of(
                HttpStatus.CONFLICT.value(),          // 409
                HttpStatus.CONFLICT.getReasonPhrase(), // "Conflict"
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }

    // 그 외 예상치 못한 모든 예외 → 500 Internal Server Error
    // (NullPointerException 등 개발자가 미처 처리 못한 예외의 최후 방어선)
    // 주의: 실제 서비스에선 e.getMessage()를 그대로 노출하면
    //       내부 구조가 새어나갈 수 있으니, 로그만 남기고
    //       사용자에겐 일반 메시지를 주는 편이 안전하다.
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpected(Exception e) {
        ErrorResponse body = ErrorResponse.of(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),          // 500
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), // "Internal Server Error"
                "서버 내부 오류가 발생했습니다."
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}