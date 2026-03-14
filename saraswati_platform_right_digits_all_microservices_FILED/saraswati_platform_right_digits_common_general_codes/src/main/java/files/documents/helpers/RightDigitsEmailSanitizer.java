package files.documents.helpers;

@FunctionalInterface
public interface RightDigitsEmailSanitizer {
    String sanitize(String email);
}

