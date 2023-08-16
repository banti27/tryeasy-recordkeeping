package in.tryeasy.recordkeeping.model.authority;


import in.tryeasy.recordkeeping.constant.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityUploadResponse {

    RequestStatus requestStatus;

}
