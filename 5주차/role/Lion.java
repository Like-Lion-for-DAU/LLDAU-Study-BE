package role;

import policy.SubmissionPolicy;
import policy.LionSubmissionPolicy;

public class Lion extends Role {
    private String studentId;

    public Lion(String name, String major, int batch, String part, String studentId) {
        super(name, major, batch, part);
        this.studentId = studentId;
    }

    @Override
    protected SubmissionPolicy getPolicy() {
        return new LionSubmissionPolicy();
    }

    @Override
    public String getInfo() {
        return "역할: [아기사자]\n" +
                getBasicInfo() + "\n" +
                "학번: " + studentId;
    }
}