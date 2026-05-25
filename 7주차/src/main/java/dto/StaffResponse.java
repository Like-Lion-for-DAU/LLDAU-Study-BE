package dto;

import Role.Staff;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class StaffResponse {
    String name;
    String major;
    int generation;
    String part;
    String position;

    public static StaffResponse from(Staff staff){
        return new StaffResponse(
                staff.getName(),
                staff.getMajor(),
                staff.getGeneration(),
                staff.getPart(),
                staff.getPosition()
        );
    }
}
