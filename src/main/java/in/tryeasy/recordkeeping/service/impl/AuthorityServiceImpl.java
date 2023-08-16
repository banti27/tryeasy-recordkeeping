package in.tryeasy.recordkeeping.service.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import in.tryeasy.recordkeeping.constant.RequestStatus;
import in.tryeasy.recordkeeping.entity.Authority;
import in.tryeasy.recordkeeping.model.authority.*;
import in.tryeasy.recordkeeping.repository.AuthorityRepository;
import in.tryeasy.recordkeeping.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {


    private final AuthorityRepository authorityRepository;

    @Override
    public AuthorityCreateResponse addAuthority(AuthorityCreateRequest request) {
        var authority = Authority.builder().authorityName(request.getAuthorityName()).build();
        authority = this.authorityRepository.save(authority);
        return AuthorityCreateResponse.builder().authorityId(authority.getAuthorityId()).build();
    }

    @Override
    public List<AuthorityDetail> getAllAuthority() {
        return this.authorityRepository.findAll()
                .stream()
                .map(authority -> AuthorityDetail.builder()
                        .authorityId(authority.getAuthorityId())
                        .authorityName(authority.getAuthorityName())
                        .build()
                )
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public AuthorityUploadResponse uploadAuthority(MultipartFile file) {
        try {
            final var authorities = new CsvToBeanBuilder<AuthorityUploadRequest>
                    (new InputStreamReader(file.getInputStream()))
                    .withType(AuthorityUploadRequest.class)
                    .build()
                    .parse()
                    .stream()
                    .map(request -> Authority.builder().authorityName(request.getAuthorityName()).build())
                    .collect(Collectors.toUnmodifiableList());

            this.authorityRepository.saveAll(authorities);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return AuthorityUploadResponse.builder().requestStatus(RequestStatus.SUCCESS).build();
    }
}
