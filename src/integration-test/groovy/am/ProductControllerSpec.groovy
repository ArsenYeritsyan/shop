package am

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import spock.lang.Stepwise
import static io.restassured.RestAssured.*
import static io.restassured.http.ContentType.JSON

@Integration
@Rollback
@Stepwise
class ProductControllerSpec extends Specification {

    void setupSpec() {
        baseURI = 'http://localhost'
        port = 8080
    }

    def "create a product"() {
        when:
        def response = given()
                .contentType(JSON)
                .body([
                        code: "P001",
                        name: "Product 1",
                        price: 100.0,
                        dateOfManufacture: "2023-07-01",
                        deadline: "2024-07-01"
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
