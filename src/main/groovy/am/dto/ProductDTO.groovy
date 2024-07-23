package am.dto

import grails.validation.Validateable

class ProductDTO implements Validateable {
    Long id
    String code
    String name
    BigDecimal price
    Date dateOfManufacture
    Date deadline

    static constraints = {
        code blank: false, unique: true
        name blank: false, maxSize: 255
        price min: 0.0
        dateOfManufacture nullable: true
        deadline nullable: true
    }
}
