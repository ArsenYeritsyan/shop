package am.domain

import grails.persistence.Entity

@Entity
class Storage {
    String code
    String name
    List<Product> products

    static hasMany = [products: Product]

    static constraints = {
        code blank: false, unique: true
        name blank: false, maxSize: 255
    }
}
