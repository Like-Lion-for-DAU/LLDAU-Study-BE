package dto;

import Role.Lion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class LionResponse {
    String name;
    String major;
    int generation;
    String part;
    int studentId;

    public static LionResponse from(Lion lion){
        return new LionResponse(
                lion.getName(),
                lion.getMajor(),
                lion.getGeneration(),
                lion.getPart(),
                lion.getStudentId()
        );
    }
}
