package role;

import policy.SubmissionPolicy;
import policy.StaffSubmissionPolicy;

public class Staff extends Role {
    private String position;

    public Staff(String name, String major, int batch, String part, String position) {
        super(name, major, batch, part);
        this.position = position;
    }

    @Override
    protected SubmissionPolicy getPolicy() {
        return new StaffSubmissionPolicy();
    }

    @Override
    public String getInfo() {
        return "[운영진]\n" +
                getBasicInfo() + "\n" +
                "직책: " + position;
    }
}