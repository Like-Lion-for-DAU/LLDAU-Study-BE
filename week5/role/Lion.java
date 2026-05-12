package week5.role;

public class Lion implements Role {
    private String name;
    private String major;
    private int generation;
    private String part;
    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.studentId = studentId;
    }

    @Override public String getName() { return name; }
    @Override public String getMajor() { return major; }
    @Override public int getGeneration() { return generation; }
    @Override public String getPart() { return part; }
    @Override public String getStudentId() { return studentId; }
    @Override public String getRoleType() { return "아기사자"; }
    @Override public boolean canSubmit() { return true; }

    @Override
    public String toString() {
        return "역할: " + getRoleType() + "\n" +
               "이름: " + name + " | 전공: " + major +
               " | 기수: " + generation + " |  파트: " + part + "\n" +
               "학번: " + studentId + "\n" +
               "과제 제출 가능: ✅ 가능";
    }
}
