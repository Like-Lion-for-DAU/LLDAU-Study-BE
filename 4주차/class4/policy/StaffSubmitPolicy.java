package class4.policy;

/**운영진의 과제 제출 정책
 * 운영진 과제 제출X -> false 반환
 */
public class StaffSubmitPolicy implements SubmitPolicy {

    @Override
    public boolean canSubmit() {
        return false;
    }
}