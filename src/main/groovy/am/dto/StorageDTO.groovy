package am.dto

import grails.validation.Validateable

class StorageDTO implements Validateable {
    String code
    String name

    static constraints = {
        code nullable: false, blank: false
        name nullable: false, blank: false
    }
}
