package week4.role;


public class Staff extends Role {

    public Staff(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part, studentId);
    }

    @Override
    public String getRoleLabel() { return "운영진"; }
}
