package am

import am.domain.Storage
import am.dto.StorageDTO
import grails.rest.RestfulController
import grails.validation.ValidationException
import am.service.StorageService
import am.service.StorageServiceImpl
import am.service.ProductServiceI

class StorageController extends RestfulController<Storage> {
    static responseFormats = ['json', 'xml']
    StorageService storageService
    StorageServiceImpl storageServiceImpl
    ProductServiceI productService

    StorageController() {
        super(Storage)
    }

    def index() {
        respond storageService.findAll(), model:[storageList: storageService.findAll()]
    }

    def save(StorageDTO storageDTO) {
        try {
            Storage storage = storageService.save(storageDTO.code, storageDTO.name)
            flash.message = "Storage saved successfully"
            redirect action: "index"
        } catch (ValidationException e) {
            flash.message = "Failed to save storage: ${e.errors}"
            redirect action: "index"
        }
    }

    def delete(Long id) {
        storageService.deleteById(id)
        flash.message = "Storage deleted successfully"
        redirect action: "index"
    }

    def addProduct(Long storageId, Long productId) {
        storageServiceImpl.addProduct(storageId, productId)
        flash.message = "Product added to storage successfully"
        redirect action: "index"
    }

    def removeProduct(Long storageId, Long productId) {
        storageServiceImpl.removeProduct(storageId, productId)
        flash.message = "Product removed from storage successfully"
        redirect action: "index"
    }
}
