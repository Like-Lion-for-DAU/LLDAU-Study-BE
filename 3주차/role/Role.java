package role;

import policy.SubmitPolicy;

public abstract class Role {
    private String name;
    private String major;
    private int batch;
    private String part;

    public Role(String name, String major, int batch, String part) {
        this.name = name;
        this.major = major;
        this.batch = batch;
        this.part = part;
    }

    protected abstract SubmitPolicy getPolicy();

    public boolean canSubmit() {
        return getPolicy().canSubmit();
    }

    protected String getBasicInfo() {
        return "이름: " + name +
                " | 전공: " + major +
                " | 기수: " + batch +
                " | 파트 (백엔드/프론트엔드/기획/디자인): " + part;
    }

    public abstract String getInfo();
}