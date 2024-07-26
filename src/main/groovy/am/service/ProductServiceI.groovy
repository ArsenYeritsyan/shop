package am.service

import am.domain.Product
import am.domain.Store
import grails.gorm.transactions.Transactional

@Transactional
interface ProductServiceI {
    Product save(String code, String name, BigDecimal price, Date dateOfManufacture, Date deadline, Store store)

    Product findById(Long id)

    List<Product> findAll()

    void deleteById(Long id)
}