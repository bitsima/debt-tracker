package bitsima.debttracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange((authorize) -> authorize
                        .pathMatchers("/api/v1/auth/**").permitAll()
                        .pathMatchers("/api/v1/taxpayer/**").hasRole("TAXPAYER")
                        .pathMatchers("/api/v1/municipality/**").hasRole("MUNICIPALITY_ADMIN")
                        .pathMatchers("/api/v1/system/**").hasRole("SYSTEM_ADMIN")
                        .anyExchange().denyAll());
        return http.build();
    }
}
