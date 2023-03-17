package com.xiilab.keycloakdemo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class SecurityConfig {
    private final JwtAuthConverter jwtAuthConverter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
//                .antMatchers("/api/v1/admin").hasRole("MANAGER")
//                .antMatchers("/api/v1/user").hasRole("MEMBER")
                .anyRequest().permitAll();
        http.oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(jwtAuthConverter);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.cors().and().csrf().disable();

        return http.build();
    }

//    public class RealmRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
//        @Override
//        public Collection<GrantedAuthority> convert(Jwt jwt) {
//            final Map<String, List<String>> realmAccess = (Map<String, List<String>>) jwt.getClaims()
//                    .get("realm_access");
//            return realmAccess.get("roles").stream().map(roleName -> "ROLE_" + roleName)
//                    // prefix required by Spring
//
//                    // Security for roles.
//                    .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
//        }
//    }
}
