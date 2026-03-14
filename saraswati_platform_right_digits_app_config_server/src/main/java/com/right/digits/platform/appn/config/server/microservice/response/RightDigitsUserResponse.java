package com.right.digits.platform.appn.config.server.microservice.response;

import java.time.Instant;

public record RightDigitsUserResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phone,
        Instant createdAt,
        Instant updatedAt
) {}
