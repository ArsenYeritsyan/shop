package am.exception

class ValidationException extends RuntimeException {
    def errors

    ValidationException(String message, errors) {
        super(message)
        this.errors = errors
    }
}
