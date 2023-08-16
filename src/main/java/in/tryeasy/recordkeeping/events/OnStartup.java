package in.tryeasy.recordkeeping.events;

import in.tryeasy.recordkeeping.entity.Authority;
import in.tryeasy.recordkeeping.entity.User;
import in.tryeasy.recordkeeping.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OnStartup {


    private final UserRepository userRepository;


    @EventListener(ApplicationReadyEvent.class)
    public void init() {

        if (this.userRepository.count() == 0) {
            final var createEmployee = Authority.builder().authorityName("CREATE_EMPLOYEE").build();
            final var createParticipants = Authority.builder().authorityName("CREATE_PARTICIPANT").build();
            final var createOrganization = Authority.builder().authorityName("CREATE_ORGANIZATION").build();
            final var createAccounts = Authority.builder().authorityName("CREATE_ACCOUNTS").build();

            final var admin = User.builder()
                    .email("admin@tryeasy.in")
                    .mobile("8602529506")
                    .secret("admin")
                    .authorities(List.of(createEmployee, createParticipants, createOrganization, createAccounts))
                    .build();

            this.userRepository.save(admin);
        }

    }


}
