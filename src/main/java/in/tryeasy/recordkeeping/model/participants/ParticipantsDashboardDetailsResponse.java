package in.tryeasy.recordkeeping.model.participants;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParticipantsDashboardDetailsResponse {
    private Page<ParticipantsDetails> participantsDashboardDetails;
}
