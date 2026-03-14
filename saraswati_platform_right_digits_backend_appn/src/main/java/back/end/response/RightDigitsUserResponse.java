package back.end.response;

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
