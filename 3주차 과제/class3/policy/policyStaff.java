package class3.policy;

public class policyStaff implements policyinter {
    @Override
    public boolean canSubmit() {
        return false;
    }
}