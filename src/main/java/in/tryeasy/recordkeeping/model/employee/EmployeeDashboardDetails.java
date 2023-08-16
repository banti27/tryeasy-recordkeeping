package in.tryeasy.recordkeeping.model.employee;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDashboardDetails {
    private List<EmployeeDetails> employeeDetailsList;
}
