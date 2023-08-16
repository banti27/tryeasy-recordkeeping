package in.tryeasy.recordkeeping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

    @GetMapping(path = {"/accounts"})
    public ModelAndView getParticipantHomePage(ModelAndView modelAndView) {


        modelAndView.setViewName("/account/accounts");
        return modelAndView;
    }

}
