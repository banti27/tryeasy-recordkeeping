package in.tryeasy.recordkeeping.controller;

import in.tryeasy.recordkeeping.model.employee.EmployeeDashboardDetailsRequest;
import in.tryeasy.recordkeeping.model.participants.ParticipantsDashboardDetailsRequest;
import in.tryeasy.recordkeeping.service.EmployeeService;
import in.tryeasy.recordkeeping.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class DashboardController {


    private final EmployeeService employeeService;
    private final ParticipantService participantService;

    @GetMapping(path = {"", "/", "/home", "/index"})
    public ModelAndView getEmployeeDashboard(ModelAndView modelAndView) {

        // Fetch all the employee details from database
        final var empDetailsPageRequest = PageRequest.of(0, 10);
        final var employeeDashboardDetailsResponse = this.employeeService
                .getAllEmployee(EmployeeDashboardDetailsRequest
                        .builder()
                        .pageRequest(empDetailsPageRequest)
                        .build());
        modelAndView.addObject("empPageInfo", employeeDashboardDetailsResponse.getEmployeeDashboardDetails());
        modelAndView.addObject("empDetails", employeeDashboardDetailsResponse
                .getEmployeeDashboardDetails()
                .get()
                .collect(Collectors.toUnmodifiableList()));

        // Fetch all participants details from database
        final var participantsDetailsPageRequest = PageRequest.of(0, 10);
        final var participantsDashboardDetailsResponse = this.participantService
                .getAllParticipants(ParticipantsDashboardDetailsRequest
                        .builder()
                        .pageRequest(participantsDetailsPageRequest)
                        .build());
        modelAndView.addObject("partyPageInfo", participantsDashboardDetailsResponse.getParticipantsDashboardDetails());
        modelAndView.addObject("participantDetails", participantsDashboardDetailsResponse
                .getParticipantsDashboardDetails()
                .get()
                .collect(Collectors.toUnmodifiableList()));

        // Set the view and return
        modelAndView.setViewName("tryeasy-dashboard");
        return modelAndView;
    }
}
