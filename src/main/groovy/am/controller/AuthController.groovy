//package am.controller
//
//import am.domain.Role
//import am.domain.User
//import grails.converters.JSON
//import grails.plugin.springsecurity.annotation.Secured
//
//class AuthController {
//
//    def springSecurityService
//    def jwtService
//
//    @Secured(['permitAll'])
//    def login() {
//        def user = springSecurityService.reauthenticate(params.username, params.password)
//        if (user) {
//            String token = jwtService.generateToken(params.username)
//            render([token: token] as JSON)
//        } else {
//            render(status: 401, text: "Unauthorized")
//        }
//    }
//
//    @Secured(['ROLE_ADMIN'])
//    def register() {
//        User user = new User(username: params.username, password: params.password)
//        user.save(flush: true)
//        Role role = Role.findByAuthority(params.role) ?: new Role(authority: params.role).save(flush: true)
//        UserRole.create(user, role, true)
//        render(status: 201, text: "User created")
//    }
//}