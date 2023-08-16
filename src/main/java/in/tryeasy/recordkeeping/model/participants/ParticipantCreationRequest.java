package in.tryeasy.recordkeeping.model.participants;

import in.tryeasy.recordkeeping.constant.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantCreationRequest {
    private String participantName;
    private String orgName;
    private Gender gender;
}
