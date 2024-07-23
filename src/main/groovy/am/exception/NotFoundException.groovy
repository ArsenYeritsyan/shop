package am.exception

class NotFoundException extends RuntimeException {
    NotFoundException(String message) {
        super(message)
    }
}
