package am.mapper

import am.domain.Product
import am.dto.ProductDTO

class ProductMapper {
    static ProductDTO toDTO(Product product) {
        new ProductDTO(
                code: product.code,
                name: product.name,
                price: product.price,
                dateOfManufacture: product.dateOfManufacture,
                deadline: product.deadline
        )
    }

    static Product toEntity(ProductDTO productDTO) {
        new Product(
                code: productDTO.code,
                name: productDTO.name,
                price: productDTO.price,
                dateOfManufacture: productDTO.dateOfManufacture,
                deadline: productDTO.deadline
        )
    }
}
