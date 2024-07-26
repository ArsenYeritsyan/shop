package am.service

import am.domain.Store
import am.dto.StoreDTO
import grails.gorm.transactions.Transactional

@Transactional
class StoreService {
    Store save(StoreDTO storeDTO) {
        def store = new Store(code: storeDTO.code, name: storeDTO.name, address: storeDTO.address)
        store.save(failOnError: true)
        return store
    }

    Store update(Long id, StoreDTO storeDTO) {
        Store store = Store.get(id)
        if (!store) {
            throw new IllegalArgumentException("Store not found")
        }
        store.code = storeDTO.code
        store.name = storeDTO.name
        store.address = storeDTO.address
        store.save(failOnError: true)
        return store
    }

    Store findById(Long id) {
        Store.get(id)
    }

    Store findByCode(String code) {
        Store.findByCode(code)
    }

    List<Store> findAll() {
        Store.list()
    }

    void deleteById(Long id) {
        Store store = findById(id)
        if (store) {
            store.delete()
        }
    }
}
