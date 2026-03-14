package com.right.digits.platform.functional.programming.microservice.helpers;

@FunctionalInterface
public interface RightDigitsEmailSanitizer {
    String sanitize(String email);
}

