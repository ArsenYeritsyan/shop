package am.dto

import grails.validation.Validateable

class StoreDTO implements Validateable {
    String code
    String name
    String address

    static constraints = {
        code nullable: false, blank: false
        name nullable: false, blank: false
        address nullable: false, blank: false
    }
}
