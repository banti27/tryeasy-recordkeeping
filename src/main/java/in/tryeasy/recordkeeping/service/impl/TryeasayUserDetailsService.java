package in.tryeasy.recordkeeping.service.impl;

import in.tryeasy.recordkeeping.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class TryeasayUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userid;
        String secret;
        var authorities = new ArrayList<GrantedAuthority>();
        try {
            final var user = this.userRepository.findByEmail(username);
            userid = user.getEmail();
            secret = user.getSecret();
            user.getAuthorities()
                    .forEach(authority -> authorities.add(new SimpleGrantedAuthority(authority.getAuthorityName())));
            return new User(userid, secret, authorities);
        } catch (DataAccessException ex) {
            try {
                final var user = this.userRepository.findByMobile(username);
                userid = user.getMobile();
                secret = user.getSecret();
                user.getAuthorities()
                        .forEach(authority -> authorities.add(new SimpleGrantedAuthority(authority.getAuthorityName())));
                return new User(userid, secret, authorities);
            } catch (DataAccessException dae) {
                throw new UsernameNotFoundException("username credentials is not correct");
            }
        }
    }
}
