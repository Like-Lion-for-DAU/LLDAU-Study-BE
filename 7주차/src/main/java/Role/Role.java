package Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public abstract class Role {
    private String name;
    private String major;
    private int generation;
    private String part;

    public void updateData(String major, int generation, String part){
        this.major = major;
        this.generation = generation;
        this.part = part;
    }
}
