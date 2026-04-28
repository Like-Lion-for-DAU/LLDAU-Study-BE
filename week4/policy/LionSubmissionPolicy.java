package week4.policy;

public class LionSubmissionPolicy implements SubmissionPolicy {

    @Override
    public boolean canSubmit() { return true; }

    @Override
    public String description() { return "가능"; }
}
