package am

import grails.web.Controller

@Controller
class ErrorController {
    def notFound() {
        render(view: '/error/404')
    }

    def internalServerError() {
        render(view: '/error/500')
    }
}
