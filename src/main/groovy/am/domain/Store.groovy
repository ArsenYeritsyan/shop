package am.domain

import grails.persistence.Entity

@Entity
class Store {
    String code
    String name
    String address
    List<Long> products
    static hasMany = [products: Product]

    static constraints = {
        code blank: false, unique: true
        name blank: false, maxSize: 255
        address blank: false, maxSize: 255
    }
}