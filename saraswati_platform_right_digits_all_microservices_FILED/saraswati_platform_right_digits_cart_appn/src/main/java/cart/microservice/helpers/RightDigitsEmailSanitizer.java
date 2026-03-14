package cart.microservice.helpers;

@FunctionalInterface
public interface RightDigitsEmailSanitizer {
    String sanitize(String email);
}

