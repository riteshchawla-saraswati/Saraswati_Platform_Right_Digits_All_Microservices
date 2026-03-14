package com.right.digits.platform.back.end.microservice.exception;

import java.time.Instant;
import java.util.List;

public record RightDigitsApiError (
        Instant timestamp,
int status,
String error,
String message,
String path,
List<String> validationErrors
) {}
