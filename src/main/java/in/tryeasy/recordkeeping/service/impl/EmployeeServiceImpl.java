package in.tryeasy.recordkeeping.service.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import in.tryeasy.recordkeeping.constant.RequestStatus;
import in.tryeasy.recordkeeping.entity.Employee;
import in.tryeasy.recordkeeping.model.employee.*;
import in.tryeasy.recordkeeping.repository.EmployeeRepository;
import in.tryeasy.recordkeeping.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

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

    @Override
    public EmployeeDashboardDetailsResponse getAllEmployee(EmployeeDashboardDetailsRequest request) {
        final var employeeDetailsPage = this.employeeRepository.findAll(request.getPageRequest())
                .map(employee -> EmployeeDetails
                        .builder()
                        .firstName(employee.getFirstName())
                        .lastName(employee.getLastName())
                        .gender(employee.getGender())
                        .build());
        return EmployeeDashboardDetailsResponse.builder().employeeDashboardDetails(employeeDetailsPage).build();
    }

    @Override
    public EmployeeUploadResponse uploadEmployee(MultipartFile file) {

        try {
            // Convert csv file row to Java Object
            final var reader = new InputStreamReader(file.getInputStream());

            List<EmployeeUploadRequest> employeeList = new CsvToBeanBuilder<EmployeeUploadRequest>(reader)
                    .withType(EmployeeUploadRequest.class)
                    .build()
                    .parse();


            // Convert all Java Object to Entity and add it to a list
            List<Employee> employeeEntityList = new ArrayList<>();


            for (var empUploadRequest : employeeList) {

                var employeeEntity = new Employee();
                employeeEntity.setFirstName(empUploadRequest.getFirstName());
                employeeEntity.setLastName(empUploadRequest.getLastName());
                employeeEntity.setGender(empUploadRequest.getGender());

                employeeEntityList.add(employeeEntity);
            }


            // save all employee to database
            this.employeeRepository.saveAll(employeeEntityList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return EmployeeUploadResponse.builder().requestStatus(RequestStatus.SUCCESS).build();
    }

}
