package in.tryeasy.recordkeeping.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/auth/users")
public class UserAuthenticationController {

    @GetMapping
    public String getLoginPage() {
        log.info("ACTION: get the login page");
        return "/auth/users";
    }


}
