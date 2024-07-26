package am.dto

import grails.validation.Validateable

class ProductDTO implements Validateable {
    String code
    String name
    BigDecimal price
    Date dateOfManufacture
    Date deadline
    Long storeId

    static constraints = {
        code nullable: false, blank: false
        name nullable: false, blank: false
        price nullable: false, min: 0.0
        dateOfManufacture nullable: false
        deadline nullable: true
        storeId nullable: false
    }
}
