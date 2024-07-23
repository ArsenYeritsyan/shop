package am.service

import am.domain.Product
import grails.gorm.services.Service

@Service(Product)
interface ProductServiceI {
    Product save(String code, String name, BigDecimal price, Date dateOfManufacture, Date deadline)

    Product findById(Long id)

    List<Product> findAll()

    void deleteById(Long id)
}
