package in.tryeasy.recordkeeping.service;

import in.tryeasy.recordkeeping.model.user.UserRegistrationRequest;
import in.tryeasy.recordkeeping.model.user.UserRegistrationResponse;

public interface UserService {
    UserRegistrationResponse registerUser(UserRegistrationRequest request);
}
