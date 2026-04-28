package week4.role;

public abstract class Role {
    protected String name;
    protected String major;
    protected int generation;
    protected String part;
    protected String studentId;

    public Role(String name, String major, int generation, String part, String studentId) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.studentId = studentId;
    }

    public String getName()      { return name; }
    public String getMajor()     { return major; }
    public int getGeneration()   { return generation; }
    public String getPart()      { return part; }
    public String getStudentId() { return studentId; }

    public abstract String getRoleLabel();
}