package am

import am.dto.ProductDTO
import am.service.ProductService
import am.service.StorageService
import am.service.StoreService

class ProductController {

    ProductService productService
    StorageService storageService
    StoreService storeService

    static allowedMethods = [save: 'POST', update: 'POST', delete: 'POST', addToStorage: 'POST', removeFromStorage: 'POST']

    def index() {
        respond([productList: productService.findAll(), storeList: storeService.findAll(), storageList: storageService.findAll()])
    }

    def save(ProductDTO productDTO) {
        try {
            productService.save(productDTO)
            flash.message = "Product saved successfully"
        } catch (Exception e) {
            flash.message = "Failed to save product: ${e.message}"
        }
        redirect(controller: 'application', action: 'index')
    }

    def delete(Long id) {
        productService.deleteById(id)
        flash.message = "Product deleted successfully"
        redirect(controller: 'application', action: 'index')
    }

    def edit(Long id) {
        def product = productService.findById(id)
        if (!prod productuct) {
            flash.message = "Product not found"
            redirect(controller: 'application', action: 'index')
            return
        }
        render(view: 'edit', model: [product: product, storeList: storeService.findAll()])
    }

    def update(ProductDTO productDTO) {
        try {
            productService.update(params.id.toLong(), productDTO)
            flash.message = "Product updated successfully"
        } catch (Exception e) {
            flash.message = "Failed to update product: ${e.message}"
            render(view: 'edit', model: [product: productService.findById(params.id.toLong()), storeList: storeService.findAll()])
            return
        }
        redirect(controller: 'application', action: 'index')
    }

    def addToStorage(Long id) {
        def product = productService.findById(id)
        if (!product) {
            flash.message = "Product not found"
            redirect(controller: 'application', action: 'index')
            return
        }
        render(view: 'addToStorage', model: [product: product, storageList: storageService.findAll()])
    }

    def addProductToStorage(Long productId, Long storageId) {
        def product = productService.findById(productId)
        def storage = storageService.findById(storageId)
        if (!product || !storage) {
            flash.message = "Product or Storage not found"
            redirect(controller: 'application', action: 'index')
            return
        }
        storageService.addProduct(storage, product)
        flash.message = "Product added to storage successfully"
        redirect(controller: 'application', action: 'index')
    }

    def removeFromStorage(Long productId, Long storageId) {
        def product = productService.findById(productId)
        def storage = storageService.findById(storageId)
        if (!product || !storage) {
            flash.message = "Product or Storage not found"
            redirect(controller: 'application', action: 'index')
            return
        }
        storageService.removeProduct(storage, product)
        flash.message = "Product removed from storage successfully"
        redirect(controller: 'application', action: 'index')
    }
}
