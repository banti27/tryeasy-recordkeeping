package in.tryeasy.recordkeeping.model.employee;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDashboardDetailsResponse {
    private Page<EmployeeDetails> employeeDashboardDetails;
}
