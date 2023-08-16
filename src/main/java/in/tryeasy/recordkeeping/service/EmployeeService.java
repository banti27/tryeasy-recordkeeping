package in.tryeasy.recordkeeping.service;

import in.tryeasy.recordkeeping.model.employee.*;
import org.springframework.web.multipart.MultipartFile;

public interface EmployeeService {

    EmployeeCreationResponse saveEmployee(EmployeeCreationRequest employeeCreationRequest);

    EmployeeDashboardDetailsResponse getAllEmployee(EmployeeDashboardDetailsRequest employeeDashboardDetailsRequest);

    EmployeeUploadResponse uploadEmployee(MultipartFile file);
}
