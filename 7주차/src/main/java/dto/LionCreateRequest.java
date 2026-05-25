package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LionCreateRequest {
    String name;
    String major;
    int generation;
    String part;
    int studentId;
}
