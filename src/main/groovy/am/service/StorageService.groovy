package am.service

import am.domain.Storage
import am.domain.Product
import am.dto.StorageDTO
import grails.gorm.transactions.Transactional

@Transactional
class StorageService implements StorageServiceI {
    @Override
    Storage save(StorageDTO storageDTO) {
        new Storage(code: storageDTO.code, name: storageDTO.name).save(failOnError: true)
    }

    @Override
    Storage findById(Long id) {
        Storage.get(id)
    }

    @Override
    List<Storage> findAll() {
        Storage.list()
    }

    @Override
    void deleteById(Long id) {
        Storage storage = findById(id)
        if (storage) {
            storage.delete()
        }
    }

    @Override
    void addProduct(Storage storage, Product product) {
        storage.addToProducts(product).save(failOnError: true)
    }

    @Override
    void removeProduct(Storage storage, Product product) {
        storage.removeFromProducts(product).save(failOnError: true)
    }
}
