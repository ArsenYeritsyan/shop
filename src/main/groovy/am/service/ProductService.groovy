package am.service

import am.domain.Product
import am.domain.Store
import grails.gorm.transactions.Transactional

@Transactional
class ProductService {

    Product save(String code, String name, BigDecimal price, Date dateOfManufacture, Date deadline, Store store) {
        new Product(code: code, name: name, price: price, dateOfManufacture: dateOfManufacture, deadline: deadline, store: store).save(failOnError: true)
    }

    Product findById(Long id) {
        Product.get(id)
    }

    List<Product> findAll() {
        Product.list()
    }

    void deleteById(Long id) {
        Product product = findById(id)
        if (product) {
            product.delete()
        }
    }
}
