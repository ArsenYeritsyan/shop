package am.dto

import grails.validation.Validateable

class StoreDTO implements Validateable {
    Long id
    String code
    String name
    String address
    List<Long> productIds

    static constraints = {
        code blank: false, unique: true
        name blank: false, maxSize: 255
        address blank: false, maxSize: 255
    }
}
