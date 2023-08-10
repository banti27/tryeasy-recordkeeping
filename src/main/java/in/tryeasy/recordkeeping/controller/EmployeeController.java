package in.tryeasy.recordkeeping.controller;

import in.tryeasy.recordkeeping.model.EmployeeCreationRequest;
import in.tryeasy.recordkeeping.model.EmployeeCreationResponse;
import in.tryeasy.recordkeeping.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(path = "/api/employee")
    public ResponseEntity<EmployeeCreationResponse> saveEmployee(@RequestBody EmployeeCreationRequest employeeCreationRequest) {


        // call EmployeeService ===> employeeCreationRequest
        final var response = this.employeeService.saveEmployee(employeeCreationRequest);


        // creating response entity
        // setting Http Status Code
        // setting Http Response Body
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }


}
