package in.tryeasy.recordkeeping.model.authority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityDetail {
    private UUID authorityId;
    private String authorityName;
}
