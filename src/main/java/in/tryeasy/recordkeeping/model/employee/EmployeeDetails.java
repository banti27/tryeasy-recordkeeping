package in.tryeasy.recordkeeping.model.employee;


import in.tryeasy.recordkeeping.constant.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDetails {
    private UUID employeeId;
    private String firstName;
    private String lastName;
    private Gender gender;
}
