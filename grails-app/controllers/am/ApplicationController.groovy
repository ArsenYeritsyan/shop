package am

import am.dto.ProductDTO
import am.dto.StorageDTO
import am.dto.StoreDTO
import am.service.ProductServiceI
import am.service.StorageServiceI
import am.service.StoreServiceI

class ApplicationController {

    ProductServiceI productService
    StorageServiceI storageService
    StoreServiceI storeService

    static allowedMethods = [saveProduct: 'POST', updateProduct: 'POST', deleteProduct: 'POST',
                             saveStore: 'POST', updateStore: 'POST', deleteStore: 'POST',
                             saveStorage: 'POST', updateStorage: 'POST', deleteStorage: 'POST']

    def index() {
        respond([productList: productService.findAll(), storeList: storeService.findAll(), storageList: storageService.findAll()])
    }

    def saveProduct(ProductDTO productDTO) {
        try {
            productService.save(productDTO)
            flash.message = "Product saved successfully"
        } catch (Exception e) {
            flash.message = "Failed to save product: ${e.message}"
        }
        redirect(action: 'index')
    }

    def deleteProduct(Long id) {
        productService.deleteById(id)
        flash.message = "Product deleted successfully"
        redirect(action: 'index')
    }

    def editProduct(Long id) {
        def product = productService.findById(id)
        if (!product) {
            flash.message = "Product not found"
            redirect(action: 'index')
            return
        }
        respond([product: product])
    }

    def updateProduct(ProductDTO productDTO) {
        try {
            productService.update(params.id.toLong(), productDTO)
            flash.message = "Product updated successfully"
        } catch (Exception e) {
            flash.message = "Failed to update product: ${e.message}"
        }
        redirect(action: 'index')
    }

    def saveStore(StoreDTO storeDTO) {
        try {
            storeService.save(storeDTO)
            flash.message = "Store saved successfully"
        } catch (Exception e) {
            flash.message = "Failed to save store: ${e.message}"
        }
        redirect(action: 'index')
    }

    def deleteStore(Long id) {
        storeService.deleteById(id)
        flash.message = "Store deleted successfully"
        redirect(action: 'index')
    }

    def editStore(Long id) {
        def store = storeService.findById(id)
        if (!store) {
            flash.message = "Store not found"
            redirect(action: 'index')
            return
        }
        respond([store: store])
    }

    def updateStore(StoreDTO storeDTO) {
        try {
            storeService.update(params.id.toLong(), storeDTO)
            flash.message = "Store updated successfully"
        } catch (Exception e) {
            flash.message = "Failed to update store: ${e.message}"
        }
        redirect(action: 'index')
    }

    def saveStorage(StorageDTO storageDTO) {
        try {
            storageService.save(storageDTO)
            flash.message = "Storage saved successfully"
        } catch (Exception e) {
            flash.message = "Failed to save storage: ${e.message}"
        }
        redirect(action: 'index')
    }

    def deleteStorage(Long id) {
        storageService.deleteById(id)
        flash.message = "Storage deleted successfully"
        redirect(action: 'index')
    }

    def editStorage(Long id) {
        def storage = storageService.findById(id)
        if (!storage) {
            flash.message = "Storage not found"
            redirect(action: 'index')
            return
        }
        respond([storage: storage])
    }

    def updateStorage(StorageDTO storageDTO) {
        try {
            storageService.update(params.id.toLong(), storageDTO)
            flash.message = "Storage updated successfully"
        } catch (Exception e) {
            flash.message = "Failed to update storage: ${e.message}"
        }
        redirect(action: 'index')
    }
}
