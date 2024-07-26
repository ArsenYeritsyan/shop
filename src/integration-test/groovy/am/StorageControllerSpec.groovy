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
class StorageControllerSpec extends Specification {

    void setupSpec() {
        baseURI = 'http://localhost'
        port = 8080
    }

    def "create a storage"() {
        when:
        def response = given()
                .contentType(JSON)
                .body([
                        code: "S001",
                        name: "Storage 1"
                ])
                .post("/api/storages")
                .then()
                .statusCode(201)
                .extract()
                .response()

        then:
        response.jsonPath().getString("code") == "S001"
        response.jsonPath().getString("name") == "Storage 1"
    }

    def "get a storage"() {
        when:
        def response = given()
                .get("/api/storages/1")
                .then()
                .statusCode(200)
                .extract()
                .response()

        then:
        response.jsonPath().getString("code") == "S001"
        response.jsonPath().getString("name") == "Storage 1"
    }

    def "get all storages"() {
        when:
        def response = given()
                .get("/api/storages")
                .then()
                .statusCode(200)
                .extract()
                .response()

        then:
        response.jsonPath().getList("").size() == 1
    }

    def "delete a storage"() {
        when:
        given()
                .delete("/api/storages/1")
                .then()
                .statusCode(204)

        then:
        given()
                .get("/api/storages/1")
                .then()
                .statusCode(404)
    }

    def "add a product to storage"() {
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

        def storageResponse = given()
                .contentType(JSON)
                .body([
                        code: "S001",
                        name: "Storage 1"
                ])
                .post("/api/storages")
                .then()
                .statusCode(201)
                .extract()
                .response()

        when:
        given()
                .post("/api/storages/addProduct?storageId=${storageResponse.jsonPath().getLong("id")}&productId=${productResponse.jsonPath().getLong("id")}")
                .then()
                .statusCode(200)

        then:
        def storage = given()
                .get("/api/storages/${storageResponse.jsonPath().getLong("id")}")
                .then()
                .statusCode(200)
                .extract()
                .response()

        storage.jsonPath().getList("products").size() == 1
    }
}

