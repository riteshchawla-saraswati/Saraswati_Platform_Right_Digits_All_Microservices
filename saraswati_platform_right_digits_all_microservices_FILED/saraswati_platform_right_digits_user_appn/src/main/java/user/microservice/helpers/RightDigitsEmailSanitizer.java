package user.microservice.helpers;

@FunctionalInterface
public interface RightDigitsEmailSanitizer {
    String sanitize(String email);
}

