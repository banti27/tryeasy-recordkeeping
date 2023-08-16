package in.tryeasy.recordkeeping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrganizationController {

    @GetMapping(path = {"/organizations", "/org/home"})
    public ModelAndView getParticipantHomePage(ModelAndView modelAndView) {


        modelAndView.setViewName("organization/organizations");
        return modelAndView;
    }

}
