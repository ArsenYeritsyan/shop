package am

class ApplicationController {
    def index() {
        def productList = Product.list()
        def storeList = Store.list()
        def storageList = Storage.list()
        render(view: "/index", model: [productList: productList, storeList: storeList, storageList: storageList])
    }
}
