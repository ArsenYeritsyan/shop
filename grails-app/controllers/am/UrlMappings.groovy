package am

class UrlMappings {

    static mappings = {
        "/api/products"(resources: 'product')
        "/api/storages"(resources: 'storage') {
            collection {
                "/addProduct"(controller: 'storage', action: 'addProduct', method: 'POST')
                "/removeProduct"(controller: 'storage', action: 'removeProduct', method: 'DELETE')
            }
        }
        "/api/stores"(resources: 'store') {
            collection {
                "/addProduct"(controller: 'store', action: 'addProduct', method: 'POST')
                "/removeProduct"(controller: 'store', action: 'removeProduct', method: 'DELETE')
            }
        }

        "/product/index"(controller: 'product', action: 'index')
        "/storage/index"(controller: 'storage', action: 'index')
        "/store/index"(controller: 'store', action: 'index')

        "/application/index"(controller: 'application', action: 'index',resources: 'product')
        "/"(view: "/index")

        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
