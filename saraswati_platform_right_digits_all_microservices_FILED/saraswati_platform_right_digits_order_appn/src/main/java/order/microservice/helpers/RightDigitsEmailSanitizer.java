package order.microservice.helpers;

@FunctionalInterface
public interface RightDigitsEmailSanitizer {
    String sanitize(String email);
}

