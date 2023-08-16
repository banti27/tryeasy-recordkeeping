package in.tryeasy.recordkeeping.model.employee;


import com.opencsv.bean.CsvBindByName;
import in.tryeasy.recordkeeping.constant.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeUploadRequest {
    @CsvBindByName(column = "First Name", required = true)
    private String firstName;

    @CsvBindByName(column = "Last Name", required = true)
    private String lastName;

    @CsvBindByName(column = "Gender", required = true)
    private Gender gender;
}
