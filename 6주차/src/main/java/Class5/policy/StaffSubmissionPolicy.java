package Class5.policy;

public class StaffSubmissionPolicy implements AssignmentPolicy {
    @Override
    public boolean canSubmit() {
        return false;
    }
}
