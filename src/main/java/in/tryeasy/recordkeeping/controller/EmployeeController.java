package in.tryeasy.recordkeeping.controller;


import in.tryeasy.recordkeeping.model.employee.EmployeeCreationRequest;
import in.tryeasy.recordkeeping.model.employee.EmployeeDashboardDetailsRequest;
import in.tryeasy.recordkeeping.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping(path = "/employees")
    public String getEmployeeRegisterPage(Model model) {
        addDashboardDetails(model);
        return "employee/employees";
    }

    @PostMapping(path = "/employees")
    public String saveEmployee(Model model, EmployeeCreationRequest employeeCreationRequest) {
        final var employeeCreationResponse = this.employeeService
                .saveEmployee(employeeCreationRequest);

        addDashboardDetails(model);
        model.addAttribute("employeeCreationResponse", employeeCreationResponse);
        return "employee/employees";
    }


    @PostMapping(path = "/employees/upload")
    public String uploadEmployee(Model model, @RequestParam("empUploadFile") MultipartFile file) {
        final var response = this.employeeService.uploadEmployee(file);
        model.addAttribute("empUploadResponse", response);
        addDashboardDetails(model);
        return "employee/employees";
    }

    private void addDashboardDetails(Model model) {
        // Fetch all the employee details from database
        final var empDetailsPageRequest = PageRequest.of(0, 20);
        final var employeeDashboardDetailsResponse = this.employeeService
                .getAllEmployee(EmployeeDashboardDetailsRequest
                        .builder()
                        .pageRequest(empDetailsPageRequest)
                        .build());
        model.addAttribute("empPageInfo", employeeDashboardDetailsResponse.getEmployeeDashboardDetails());
        model.addAttribute("empDetails", employeeDashboardDetailsResponse
                .getEmployeeDashboardDetails()
                .get()
                .collect(Collectors.toUnmodifiableList()));
        model.addAttribute("employeeCreationRequest", EmployeeCreationRequest.builder().build());
    }
}
