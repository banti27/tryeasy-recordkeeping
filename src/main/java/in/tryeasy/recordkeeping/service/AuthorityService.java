package in.tryeasy.recordkeeping.service;

import in.tryeasy.recordkeeping.model.authority.AuthorityCreateRequest;
import in.tryeasy.recordkeeping.model.authority.AuthorityCreateResponse;
import in.tryeasy.recordkeeping.model.authority.AuthorityDetail;
import in.tryeasy.recordkeeping.model.authority.AuthorityUploadResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AuthorityService {
    AuthorityCreateResponse addAuthority(AuthorityCreateRequest request);

    List<AuthorityDetail> getAllAuthority();

    AuthorityUploadResponse uploadAuthority(MultipartFile file);
}
