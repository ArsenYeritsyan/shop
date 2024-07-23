package am.service

import am.domain.Product
import am.domain.Storage
import grails.gorm.transactions.Transactional

@Transactional
class StorageServiceImpl {

    StorageService storageService

    Storage save(String code, String name) {
        storageService.save(code, name)
    }

    Storage findById(Long id) {
        storageService.findById(id)
    }

    List<Storage> findAll() {
        storageService.findAll()
    }

    void deleteById(Long id) {
        storageService.deleteById(id)
    }

    void addProduct(Long storageId, Long productId) {
        Storage storage = findById(storageId)
        Product product = Product.get(productId)
        if (storage && product) {
            storage.addToProducts(product)
            storage.save()
        }
    }

    void removeProduct(Long storageId, Long productId) {
        Storage storage = findById(storageId)
        Product product = Product.get(productId)
        if (storage && product) {
            storage.removeFromProducts(product)
            storage.save()
        }
    }
}
