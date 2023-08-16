package in.tryeasy.recordkeeping.model.participants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantCreationResponse {
    private UUID participantId;
}
