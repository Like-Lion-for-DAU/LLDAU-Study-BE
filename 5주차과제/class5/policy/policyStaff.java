package class5.policy;

public class policyStaff implements policyinter {
    @Override
    public boolean canSubmit() {
        return false;
    }
}