package client.management.helpers;

@FunctionalInterface
public interface RightDigitsEmailSanitizer {
    String sanitize(String email);
}

