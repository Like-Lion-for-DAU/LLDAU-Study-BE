package class3.policy;

public class StaffAssignmentPolicy implements AssignmentPolicy {
    @Override
    public boolean canSubmit() {
        return false; // 운영진은 제출 불가
    }
}