package week4.policy;

public class StaffSubmissionPolicy implements SubmissionPolicy {

    @Override
    public boolean canSubmit() { return false; }

    @Override
    public String description() { return "불가"; }
}
