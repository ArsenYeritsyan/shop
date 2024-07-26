package am.domain

import grails.gorm.annotation.Entity

@Entity
class Storage {
    String code
    String name
    static hasMany = [products: Product]

    static constraints = {
        code nullable: false, blank: false, unique: true
        name nullable: false, blank: false
    }
}
