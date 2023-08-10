package in.tryeasy.recordkeeping.service.impl;

import in.tryeasy.recordkeeping.entity.Employee;
import in.tryeasy.recordkeeping.model.EmployeeCreationRequest;
import in.tryeasy.recordkeeping.model.EmployeeCreationResponse;
import in.tryeasy.recordkeeping.repository.EmployeeRepository;
import in.tryeasy.recordkeeping.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeCreationResponse saveEmployee(EmployeeCreationRequest employeeCreationRequest) {


        var employee = new Employee();
        employee.setFirstName(employeeCreationRequest.getFirstName());
        employee.setLastName(employeeCreationRequest.getLastName());
        employee.setGender(employeeCreationRequest.getGender());

        employee = this.employeeRepository.save(employee);

        final var response = new EmployeeCreationResponse();
        response.setEmployeeId(employee.getEmployeeId());

        return response;
    }

}
