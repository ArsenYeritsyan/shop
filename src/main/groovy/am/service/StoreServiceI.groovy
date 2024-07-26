package am.service

import am.dto.StoreDTO
import am.domain.Store
import grails.gorm.transactions.Transactional

@Transactional
interface StoreServiceI {
    Store save(StoreDTO storeDTO)
    Store update(Long id, StoreDTO storeDTO)
    Store findById(Long id)
    Store findByCode(String code)
    List<Store> findAll()
    void deleteById(Long id)
}
