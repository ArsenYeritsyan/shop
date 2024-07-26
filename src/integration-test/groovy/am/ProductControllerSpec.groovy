package am

import am.domain.Product
import am.domain.Store
import am.service.ProductService
import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import spock.lang.Specification
import spock.lang.Stepwise

import static io.restassured.RestAssured.*
import static io.restassured.http.ContentType.JSON

@Integration
@Rollback
@Stepwise
class ProductControllerSpec extends Specification {
    ProductService productService

    void setupSpec() {
        baseURI = 'http://localhost'
        port = 8080
    }

    void "test save product"() {
        given: "A new product"
        def store = new Store(code: 'S001', name: 'Store 1', address: '123 Main St').save(flush: true)
        def product = new Product(code: 'P001', name: 'Product 1', price: 100.0, dateOfManufacture: new Date(), deadline: new Date() + 365, store: store)

        when: "The product is saved"
        productService.save(product.code, product.name, (BigDecimal) product.price, (Date) product.dateOfManufacture, (Date) product.deadline, product.store)

        then: "The product is saved in the database"
        def savedProduct = Product.findByCode('P001')
        savedProduct != null
        savedProduct.name == 'Product 1'
    }

    def "create a product"() {
        when:
        def response = given()
                .contentType(JSON)
                .body([
                        code             : "P001",
                        name             : "Product 1",
                        price            : 100.0,
                        dateOfManufacture: "2023-07-01",
                        deadline         : "2024-07-01"
                ])
                .post("/api/products")
                .then()
                .statusCode(201)
                .extract()
                .response()

        then:
        response.jsonPath().getString("code") == "P001"
        response.jsonPath().getString("name") == "Product 1"
    }

    def "get a product"() {
        when:
        def response = given()
                .get("/api/products/1")
                .then()
                .statusCode(200)
                .extract()
                .response()

        then:
        response.jsonPath().getString("code") == "P001"
        response.jsonPath().getString("name") == "Product 1"
    }

    def "get all products"() {
        when:
        def response = given()
                .get("/api/products")
                .then()
                .statusCode(200)
                .extract()
                .response()

        then:
        response.jsonPath().getList("").size() == 1
    }

    def "delete a product"() {
        when:
        given()
                .delete("/api/products/1")
                .then()
                .statusCode(204)

        then:
        given()
                .get("/api/products/1")
                .then()
                .statusCode(404)
    }
}
