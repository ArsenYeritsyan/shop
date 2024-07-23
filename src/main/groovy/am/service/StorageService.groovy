package am.service

import am.domain.Storage
import grails.gorm.services.Service

@Service(Storage)
interface StorageService {
    Storage save(String code, String name)

    Storage findById(Long id)

    List<Storage> findAll()

    void deleteById(Long id)

//    void addProduct(Long storageId, Long productId)

//    void removeProduct(Long storageId, Long productId)
}