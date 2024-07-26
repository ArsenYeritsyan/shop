package am.domain

import grails.gorm.annotation.Entity

@Entity
class Store {
    String code
    String name
    String address
    static hasMany = [products: Product]

    static constraints = {
        code nullable: false, blank: false, unique: true
        name nullable: false, blank: false
        address nullable: false, blank: false
    }
}
