package am.service

import am.domain.Store
import grails.gorm.services.Service

@Service(Store)
interface StoreService {
    Store save(String code, String name, String address)

    Store findById(Long id)

    List<Store> findAll()

    void deleteById(Long id)
    Store findByCode(String code)

//    void addProduct(Long storeId, Long productId)
//
//    void removeProduct(Long storeId, Long productId)
}