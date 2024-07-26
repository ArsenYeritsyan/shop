package am.domain

import grails.gorm.annotation.Entity

@Entity
class Product {
    String code
    String name
    BigDecimal price
    Date dateOfManufacture
    Date deadline
    Store store

    static belongsTo = [store: Store]

    static constraints = {
        code nullable: false, blank: false, unique: true
        name nullable: false, blank: false
        price nullable: false, min: 0.0
        dateOfManufacture nullable: false
        deadline nullable: true
        store nullable: false
    }
}
