package am.service

import am.domain.Product
import am.domain.Store
import grails.gorm.transactions.Transactional

@Transactional
class StoreServiceImpl {

    StoreService storeService

    Store save(String code, String name, String address) {
        storeService.save(code, name, address)
    }

    Store findById(Long id) {
        storeService.findById(id)
    }

    List<Store> findAll() {
        storeService.findAll()
    }

    void deleteById(Long id) {
        storeService.deleteById(id)
    }

    void addProduct(Long storeId, Long productId) {
        Store store = findById(storeId)
        Product product = Product.get(productId)
        if (store && product) {
            store.addToProducts(product)
            store.save()
        }
    }

    void removeProduct(Long storeId, Long productId) {
        Store store = findById(storeId)
        Product product = Product.get(productId)
        if (store && product) {
            store.removeFromProducts(product)
            store.save()
        }
    }
}
