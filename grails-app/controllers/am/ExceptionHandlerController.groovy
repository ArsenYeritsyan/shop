package am


import am.exception.NotFoundException
import am.exception.ValidationException

class ExceptionHandlerController {
    def handleValidationException(ValidationException e) {
        respond([error: e.errors], status: 400)
    }

    def handleNotFoundException(NotFoundException e) {
        respond([error: e.message], status: 404)
    }
}
