package am

import am.domain.Store
import am.dto.StoreDTO
import grails.rest.RestfulController
import grails.validation.ValidationException
import am.service.StoreService
import am.service.StoreServiceImpl
import am.service.ProductServiceI

class StoreController extends RestfulController<Store> {
    static responseFormats = ['json', 'xml']
    StoreService storeService
    StoreServiceImpl storeServiceImpl
    ProductServiceI productService

    StoreController() {
        super(Store)
    }

    def index() {
        respond storeService.findAll(), model:[storeList: storeService.findAll()]
    }

    def save(StoreDTO storeDTO) {
        try {
            Store store = storeService.save(storeDTO.code, storeDTO.name, storeDTO.address)
            flash.message = "Store saved successfully"
            redirect action: "index"
        } catch (ValidationException e) {
            flash.message = "Failed to save store: ${e.errors}"
            redirect action: "index"
        }
    }

    def delete(Long id) {
        storeService.deleteById(id)
        flash.message = "Store deleted successfully"
        redirect action: "index"
    }

    def addProduct(Long storeId, Long productId) {
        storeServiceImpl.addProduct(storeId, productId)
        flash.message = "Product added to store successfully"
        redirect action: "index"
    }

    def removeProduct(Long storeId, Long productId) {
        storeServiceImpl.removeProduct(storeId, productId)
        flash.message = "Product removed from store successfully"
        redirect action: "index"
    }
}
