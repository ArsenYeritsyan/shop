package am.domain

class UserRole implements Serializable {
    User user
    Role role

    static mapping = {
        id composite: ['role', 'user']
        version false
    }
}
