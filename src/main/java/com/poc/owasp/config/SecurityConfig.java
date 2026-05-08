package com.poc.owasp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Profile("vulnerable")
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            // CWE-862, CWE-863
            // Misconfigured filter chain exposes protected endpoints
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/secure/**").permitAll()
                .requestMatchers("/crypto/**").permitAll()

                // Security Misconfiguration
                .requestMatchers("/config/**").permitAll()

                .anyRequest().authenticated()
            )

            .httpBasic(basic -> {});

        return http.build();
    }
}