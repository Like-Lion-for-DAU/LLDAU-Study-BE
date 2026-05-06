package class4.policy;

/**아기사자의 과제 제출 정책
 * 아기사자-과제 제출O -> true 반환 
*/
public class LionSubmitPolicy implements SubmitPolicy {

    @Override
    public boolean canSubmit() {
        return true;
    }
}
