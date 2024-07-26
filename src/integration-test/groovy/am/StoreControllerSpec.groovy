package am

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import spock.lang.Specification
import spock.lang.Stepwise

import static io.restassured.RestAssured.*
import static io.restassured.http.ContentType.JSON

@Integration
@Rollback
@Stepwise
class StoreControllerSpec extends Specification {

    void setupSpec() {
        baseURI = 'http://localhost'
        port = 8080
    }

    def "create a store"() {
        when:
        def response = given()
                .contentType(JSON)
                .body([
                        code   : "ST001",
                        name   : "Store 1",
                        address: "Address 1"
                ])
                .post("/api/stores")
                .then()
                .statusCode(201)
                .extract()
                .response()

        then:
        response.jsonPath().getString("code") == "ST001"
        response.jsonPath().getString("name") == "Store 1"
        response.jsonPath().getString("address") == "Address 1"
    }

    def "get a store"() {
        when:
        def response = given()
                .get("/api/stores/1")
                .then()
                .statusCode(200)
                .extract()
                .response()

        then:
        response.jsonPath().getString("code") == "ST001"
        response.jsonPath().getString("name") == "Store 1"
        response.jsonPath().getString("address") == "Address 1"
    }

    def "get all stores"() {
        when:
        def response = given()
                .get("/api/stores")
                .then()
                .statusCode(200)
                .extract()
                .response()

        then:
        response.jsonPath().getList("").size() == 1
    }

    def "delete a store"() {
        when:
        given()
                .delete("/api/stores/1")
                .then()
                .statusCode(204)

        then:
        given()
                .get("/api/stores/1")
                .then()
                .statusCode(404)
    }

    def "add a product to store"() {
        given:
        def productResponse = given()
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

        def storeResponse = given()
                .contentType(JSON)
                .body([
                        code   : "ST001",
                        name   : "Store 1",
                        address: "Address 1"
                ])
                .post("/api/stores")
                .then()
                .statusCode(201)
                .extract()
                .response()

        when:
        given()
                .post("/api/stores/addProduct?storeId=${storeResponse.jsonPath().getLong("id")}&productId=${productResponse.jsonPath().getLong("id")}")
                .then()
                .statusCode(200)

        then:
        def store = given()
                .get("/api/stores/${storeResponse.jsonPath().getLong("id")}")
                .then()
                .statusCode(200)
                .extract()
                .response()

        store.jsonPath().getList("products").size() == 1
    }
}
