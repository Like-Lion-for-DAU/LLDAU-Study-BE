package Role;

import lombok.Getter;

@Getter
public class Lion extends Role {
    private int studentId;

    public Lion(String name, String major, int generation, String part, int studentId){
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    public void update(String major, int generation, String part, int studentId){
        super.updateData(major,generation,part);
        this.studentId = studentId;
    }
}
