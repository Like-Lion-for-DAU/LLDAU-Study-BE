package policy;

public class LionSubmissionPolicy implements AssignmentPolicy {
    @Override
    public boolean canSubmit() {
        return true;
    }
}
