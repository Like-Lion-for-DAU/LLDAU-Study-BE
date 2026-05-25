package Role;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Staff extends Role{

    private String position;
    public Staff(String name, String major, int generation, String part,String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    public void update(String major, int generation, String part, String position){
        super.updateData(major, generation, part);
        this.position = position;
    }
}
