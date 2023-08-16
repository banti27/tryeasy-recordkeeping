package in.tryeasy.recordkeeping.service.impl;

import in.tryeasy.recordkeeping.entity.Participant;
import in.tryeasy.recordkeeping.model.participants.*;
import in.tryeasy.recordkeeping.repository.ParticipantRepository;
import in.tryeasy.recordkeeping.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository;

    @Override
    public ParticipantCreationResponse saveParticipant(ParticipantCreationRequest request) {

        Participant participant = new Participant();
        participant.setParticipantName(request.getParticipantName());
        participant.setOrgName(request.getOrgName());
        participant.setGender(request.getGender());

        participant = this.participantRepository.save(participant);

        ParticipantCreationResponse response = new ParticipantCreationResponse();
        response.setParticipantId(participant.getParticipantId());
        return response;
    }

    @Override
    public ParticipantsDashboardDetailsResponse getAllParticipants(ParticipantsDashboardDetailsRequest request) {
        final var participantsDetails = this.participantRepository.findAll(request.getPageRequest())
                .map(participant -> ParticipantsDetails.builder()
                        .participantId(participant.getParticipantId())
                        .participantName(participant.getParticipantName())
                        .orgName(participant.getOrgName())
                        .gender(participant.getGender())
                        .build());

        return ParticipantsDashboardDetailsResponse.builder()
                .participantsDashboardDetails(participantsDetails)
                .build();
    }

}
