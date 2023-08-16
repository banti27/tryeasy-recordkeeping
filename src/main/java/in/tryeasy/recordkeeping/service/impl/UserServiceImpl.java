package in.tryeasy.recordkeeping.service.impl;

import in.tryeasy.recordkeeping.entity.User;
import in.tryeasy.recordkeeping.model.user.UserRegistrationRequest;
import in.tryeasy.recordkeeping.model.user.UserRegistrationResponse;
import in.tryeasy.recordkeeping.repository.UserRepository;
import in.tryeasy.recordkeeping.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserRegistrationResponse registerUser(UserRegistrationRequest request) {

        var user = User.builder()
                .email(request.getEmail())
                .secret(request.getPassword())
                .build();

        user = this.userRepository.save(user);

        return UserRegistrationResponse.builder().userId(user.getUserId()).build();
    }


}
