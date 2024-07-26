package am.service

import am.domain.Product
import am.dto.StorageDTO
import am.domain.Storage
import grails.gorm.transactions.Transactional

@Transactional
interface StorageServiceI {
    Storage save(StorageDTO storageDTO)
    Storage findById(Long id)
    List<Storage> findAll()
    void deleteById(Long id)
    void addProduct(Storage storage, Product product)
    void removeProduct(Storage storage, Product product)
}
