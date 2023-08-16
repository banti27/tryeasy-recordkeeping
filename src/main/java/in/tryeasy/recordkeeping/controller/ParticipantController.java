package in.tryeasy.recordkeeping.controller;

import in.tryeasy.recordkeeping.model.participants.ParticipantCreationRequest;
import in.tryeasy.recordkeeping.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;

    @GetMapping(path = {"/participants"})
    public ModelAndView getParticipantHomePage(ModelAndView modelAndView) {
        modelAndView.addObject("participantCreationRequest",
                ParticipantCreationRequest.builder().build());
        modelAndView.setViewName("participant/participants");
        return modelAndView;
    }


    @PostMapping(path = {"/participants"})
    public ModelAndView saveParticipant(ModelAndView modelAndView, ParticipantCreationRequest participantCreationRequest) {
        final var participantCreationResponse = this.participantService.saveParticipant(participantCreationRequest);
        modelAndView.addObject("participantCreationResponse", participantCreationResponse);
        modelAndView.setViewName("participant/participants");
        return modelAndView;
    }

}
