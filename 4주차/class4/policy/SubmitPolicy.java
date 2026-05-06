package class4.policy;

/** 과제 제출 가능 여부 판단 정책 인터페이스
 * 각 역할에 따라 다른 제출 정책을 정의하기 위한 코드
*/
public interface SubmitPolicy {
    // @return true: 제출 가능, false: 제출 불가능
    boolean canSubmit();
}