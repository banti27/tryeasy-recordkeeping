package in.tryeasy.recordkeeping.model.authority;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityCreateRequest {

    private String authorityName;

}
