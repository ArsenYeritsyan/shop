package shop
//@Transactional
class ProductService {

    def list() {
        return Product.list()
    }

    def get(Long id) {
        return Product.get(id)
    }

    def save(Product product) {
        if (product.validate()) {
            product.save(flush: true)
        } else {
            throw new RuntimeException("Validation failed", product.errors)
        }
    }

    def delete(Long id) {
        def product = Product.get(id)
        if (product) {
            product.delete(flush: true)
            return true
        }
        return false
    }
    def createProduct(params) {
        def product = new Product(params)
        if (product.save(flush: true)) {
            return product
        } else {
            throw new RuntimeException("Failed to create product")
        }
    }

    def editProduct(Product product, params) {
        product.properties = params
        if (product.save(flush: true)) {
            return product
        } else {
            throw new RuntimeException("Failed to edit product")
        }
    }

    def deleteProduct(Product product) {
        if (product.delete(flush: true)) {
            return true
        } else {
            throw new RuntimeException("Failed to delete product")
        }
    }
}
