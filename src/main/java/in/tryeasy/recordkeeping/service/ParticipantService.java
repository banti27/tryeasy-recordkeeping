package in.tryeasy.recordkeeping.service;

import in.tryeasy.recordkeeping.model.participants.ParticipantCreationRequest;
import in.tryeasy.recordkeeping.model.participants.ParticipantCreationResponse;
import in.tryeasy.recordkeeping.model.participants.ParticipantsDashboardDetailsRequest;
import in.tryeasy.recordkeeping.model.participants.ParticipantsDashboardDetailsResponse;

public interface ParticipantService {

    ParticipantCreationResponse saveParticipant(ParticipantCreationRequest request);

    ParticipantsDashboardDetailsResponse getAllParticipants(ParticipantsDashboardDetailsRequest request);

}
