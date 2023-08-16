package in.tryeasy.recordkeeping.model.participants;


import in.tryeasy.recordkeeping.constant.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParticipantsDetails {
    private UUID participantId;
    private String orgName;
    private String participantName;
    private Gender gender;
}
