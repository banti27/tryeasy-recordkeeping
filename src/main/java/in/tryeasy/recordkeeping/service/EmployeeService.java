package in.tryeasy.recordkeeping.service;

import in.tryeasy.recordkeeping.model.EmployeeCreationRequest;
import in.tryeasy.recordkeeping.model.EmployeeCreationResponse;

public interface EmployeeService {
    EmployeeCreationResponse saveEmployee(EmployeeCreationRequest employeeCreationRequest);
}
