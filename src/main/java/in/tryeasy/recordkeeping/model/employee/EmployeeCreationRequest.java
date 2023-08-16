package in.tryeasy.recordkeeping.model.employee;

import in.tryeasy.recordkeeping.constant.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreationRequest {
    private String firstName;
    private String lastName;
    private Gender gender;
}

