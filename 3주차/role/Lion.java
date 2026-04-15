package role;

import policy.SubmitPolicy;
import policy.LionSubmitPolicy;

public class Lion extends Role {
    private String studentId;

    public Lion(String name, String major, int batch, String part, String studentId) {
        super(name, major, batch, part);
        this.studentId = studentId;
    }

    @Override
    protected SubmitPolicy getPolicy() {
        return new LionSubmitPolicy();
    }

    @Override
    public String getInfo() {
        return "역할: [아기사자]\n" +
                getBasicInfo() + "\n" +
                "학번: " + studentId;
    }
}