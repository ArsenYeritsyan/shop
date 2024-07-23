package am.dto

import grails.validation.Validateable

class StorageDTO implements Validateable {
    Long id
    String code
    String name
    List<Long> productIds

    static constraints = {
        code blank: false, unique: true
        name blank: false, maxSize: 255
    }
}

