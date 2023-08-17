package in.tryeasy.recordkeeping.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
        return http.cors(httpSecurity -> httpSecurity.disable())
                .csrf(httpSecurity -> httpSecurity.disable())
                .authorizeHttpRequests(httpRequest ->
                        httpRequest
                                .requestMatchers(
                                        mvc.pattern("/auth/users"),
                                        mvc.pattern("/register/users")
                                )
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .logout(httpSecurity -> httpSecurity.logoutSuccessUrl("/auth/users"))
                .formLogin(form -> form
                        .loginPage("/auth/users")
                ).build();
    }

    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /*@Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }*/

    /*@Bean
    public UserDetailsService users() {
        // The builder will ensure the passwords are encoded before saving in memory
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        UserDetails user = users
                .username("bunty")
                .password("bunty")
                .roles("CREATE_EMPLOYEE")
                .build();
        UserDetails admin = users
                .username("admin")
                .password("admin")
                .roles("CREATE_EMPLOYEE", "CREATE_PARTICIPANT", "CREATE_ORGANIZATION", "CREATE_ACCOUNTS")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }*/

}
