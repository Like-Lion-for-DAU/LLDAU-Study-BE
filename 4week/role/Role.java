package role;

import policy.HomeworkPolicy;

import java.util.List;

public abstract class Role {
    public abstract HomeworkPolicy getHomeworkPolicy();
    public abstract void describeSelf();

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

    public static void assertNameUnique(List<Role> members, String name) {
        if(members.stream().anyMatch(member -> member.getName().equals(name))) {
            throw new IllegalArgumentException("이미 존재하는 이름.");
        }
    }
}
