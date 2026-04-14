package role;

import policy.HomeworkPolicy;

public abstract class Role {
    private String name;
    private String major;
    private Integer year;
    private String part;

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public Integer getYear() {
        return year;
    }

    public String getPart() {
        return part;
    }

    public Role(String name, String major, Integer year, String part) {
        this.name = name;
        this.major = major;
        this.year = year;
        this.part = part;
    }

    public Boolean isSubmittable() {
        return getHomeworkPolicy().isSubmittable();
    }

    public abstract HomeworkPolicy getHomeworkPolicy();
    public abstract String describeSelf();
}
