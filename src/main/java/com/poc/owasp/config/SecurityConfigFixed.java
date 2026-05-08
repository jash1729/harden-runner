package com.poc.owasp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@Profile("secure")
public class SecurityConfigFixed {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/crypto/**").permitAll()
                .requestMatchers("/secure/crypto/**").permitAll()

                // Admin protected
                .requestMatchers("/secure/config/admin/**").hasRole("ADMIN")

                // Config endpoints require auth
                .requestMatchers("/secure/config/**").authenticated()

                .requestMatchers("/secure/**").authenticated()
                .anyRequest().authenticated()
            )

            .httpBasic(basic -> {});

        return http.build();
    }
}