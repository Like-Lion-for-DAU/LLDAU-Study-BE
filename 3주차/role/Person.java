package role;

import policy.SubmitPolicy;

public abstract class Person {
    private String name;
    private String major;
    private int generation;
    private String part;

    public Person(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getGeneration() {
        return generation;
    }

    public String getPart() {
        return part;
    }

    public boolean canSubmitAssignment() {
        return getSubmitPolicy().canSubmit();
    }

    public abstract SubmitPolicy getSubmitPolicy();

    public abstract String getRoleName();

    public abstract String getDetailInfo();
}