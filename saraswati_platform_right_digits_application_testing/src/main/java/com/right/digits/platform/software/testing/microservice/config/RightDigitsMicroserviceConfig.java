package com.right.digits.platform.software.testing.microservice.config;

import com.right.digits.platform.software.testing.microservice.helpers.RightDigitsEmailSanitizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RightDigitsMicroserviceConfig {

    // A simple custom bean to demonstrate Spring Beans
    @Bean
    public RightDigitsEmailSanitizer emailSanitizer() {
        return email -> email == null ? null : email.trim().toLowerCase();
    }
}
