package com.right.digits.platform.kafka.consumer.microservice.config;

import com.right.digits.platform.kafka.consumer.microservice.helpers.RightDigitsEmailSanitizer;
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
