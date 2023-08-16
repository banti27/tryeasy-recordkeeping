package in.tryeasy.recordkeeping.model.authority;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityUploadRequest {
    @CsvBindByName(column = "Authority Name", required = true)
    private String authorityName;
}
