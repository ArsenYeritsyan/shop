package am.domain

import grails.persistence.Entity

@Entity
class Product {
    String code
    String name
    BigDecimal price
    Date dateOfManufacture
    Date deadline

    static belongsTo = [store: Store]

    static constraints = {
        code blank: false, unique: true
        name blank: false, maxSize: 255
        price min: 0.0
        dateOfManufacture nullable: false
        deadline nullable: true
    }
}
