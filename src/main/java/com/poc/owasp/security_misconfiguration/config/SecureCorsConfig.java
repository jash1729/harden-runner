package com.poc.owasp.security_misconfiguration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@Profile("secure")
public class SecureCorsConfig {

    // CWE-16
    // Restrictive CORS configuration
    @Bean
    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/api/**")
                        .allowedOrigins("https://trusted-app.com")
                        .allowedMethods("GET", "POST")
                        .allowedHeaders("Content-Type", "Authorization");
            }
        };
    }
}