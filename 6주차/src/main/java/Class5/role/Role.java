package Class5.role;

import Class5.policy.AssignmentPolicy;

public abstract class Role {
    protected String name;
    protected String major;
    protected int generation;
    protected String part;

    public abstract AssignmentPolicy getAssignmentPolicy();

    public boolean canSubmit() {
        return getAssignmentPolicy().canSubmit();
    }

    public abstract void getInfo();

    public String getName() {
        return name;
    }

    public String getPart() {
        return part;
    }
}
