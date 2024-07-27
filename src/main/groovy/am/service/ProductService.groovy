package am.service

import am.domain.Product
import am.domain.Store
import am.dto.ProductDTO
import grails.gorm.transactions.Transactional


@Transactional
class ProductService implements ProductServiceI {
    Product save(ProductDTO productDTO) {
        Store store = Store.get(productDTO.storeId)
        if (!store) {
            throw new IllegalArgumentException("Store not found")
        }
        new Product(code: productDTO.code, name: productDTO.name, price: productDTO.price, dateOfManufacture: productDTO.dateOfManufacture, deadline: productDTO.deadline, store: store).save(failOnError: true)
    }


    Product update(Long id, ProductDTO productDTO) {
        Product product = Product.get(id)
        if (!product) {
            throw new IllegalArgumentException("Product not found")
        }
        Store store = Store.get(productDTO.storeId)
        if (!store) {
            throw new IllegalArgumentException("Store not found")
        }
        product.code = productDTO.code
        product.name = productDTO.name
        product.price = productDTO.price
        product.dateOfManufacture = productDTO.dateOfManufacture
        product.deadline = productDTO.deadline
        product.store = store
        product.save(failOnError: true)
    }

    @Override
    Product save(String code, String name, BigDecimal price, Date dateOfManufacture, Date deadline, Store store) {
        new Product(code: code, name: name, price: price, dateOfManufacture: dateOfManufacture, deadline: deadline, store: store).save(failOnError: true)
    }

    @Override
    Product findById(Long id) {
        Product.get(id)
    }

    @Override
    List<Product> findAll() {
        Product.list()
    }

    @Override
    void deleteById(Long id) {
        Product product = findById(id)
        if (product) {
            product.delete()
        }
    }
}
