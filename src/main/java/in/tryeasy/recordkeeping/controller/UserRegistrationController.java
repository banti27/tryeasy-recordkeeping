package in.tryeasy.recordkeeping.controller;


import in.tryeasy.recordkeeping.model.user.UserRegistrationRequest;
import in.tryeasy.recordkeeping.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/register/users")
@RequiredArgsConstructor
public class UserRegistrationController {

    private final UserService userService;

    @GetMapping
    public String getUserRegistrationPage(Model model) {
        log.info("ACTION: get user registration page");
        model.addAttribute("userRegReq", UserRegistrationRequest.builder().build());
        return "/register/users";
    }

    @PostMapping
    public String registerUser(Model model, UserRegistrationRequest userRegistrationRequest) {
        log.info("ACTION: start user registration");

        this.userService.registerUser(userRegistrationRequest);
        return "/auth/users";
    }


}
