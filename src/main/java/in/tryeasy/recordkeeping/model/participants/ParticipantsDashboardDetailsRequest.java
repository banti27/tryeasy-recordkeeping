package in.tryeasy.recordkeeping.model.participants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParticipantsDashboardDetailsRequest {

    private PageRequest pageRequest;

}
