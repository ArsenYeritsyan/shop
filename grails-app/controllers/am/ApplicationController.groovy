package am

import am.service.ProductService
import am.service.ProductServiceI
import am.service.StorageService
import am.service.StorageServiceI
import am.service.StoreService
import am.service.StoreServiceI

class ApplicationController {

    ProductService productService
    StoreService storeService
    StorageService storageService

    def index() {
        def productList = productService.findAll()
        def storeList = storeService.findAll()
        def storageList = storageService.findAll()
        render(view: "/application/index", model: [productList: productList, storeList: storeList, storageList: storageList])
    }
}
