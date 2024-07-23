package am

import am.domain.Product
import am.dto.ProductDTO
import am.service.ProductService
import grails.rest.RestfulController
import grails.validation.ValidationException

class ProductController extends RestfulController<Product> {
    static responseFormats = ['json', 'xml']
    ProductService productService

    ProductController() {
        super(Product)
    }

    def index() {
        respond productService.findAll(), model:[productList: productService.findAll()]
    }

    def save(ProductDTO productDTO) {
        try {
            productService.save(
                    productDTO.code, productDTO.name, productDTO.price, productDTO.dateOfManufacture, productDTO.deadline
            )
            flash.message = "Product saved successfully"
            redirect action: "index"
        } catch (ValidationException e) {
            flash.message = "Failed to save product: ${e.errors}"
            redirect action: "index"
        }
    }

    def delete(Long id) {
        productService.deleteById(id)
        flash.message = "Product deleted successfully"
        redirect action: "index"
    }
}
