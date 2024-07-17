package shop

class StoreService {
    def addProductToStore(Store store, Product product, int quantity) {
        def storeProduct = new StoreProduct(product: product, quantity: quantity, store: store)
        store.addToProducts(storeProduct)
        if (store.save(flush: true)) {
            return store
        } else {
            throw new RuntimeException("Failed to add product to store")
        }
    }

    def sellProduct(Store store, Product product, int quantity) {
        def storeProduct = StoreProduct.findByStoreAndProduct(store, product)
        if (storeProduct && storeProduct.quantity >= quantity) {
            storeProduct.quantity -= quantity
            if (storeProduct.save(flush: true)) {
                return storeProduct
            } else {
                throw new RuntimeException("Failed to sell product")
            }
        } else {
            throw new RuntimeException("Insufficient stock or product not found")
        }
    }

    def returnProductToStorage(Store store, Product product, int quantity) {
        def storeProduct = StoreProduct.findByStoreAndProduct(store, product)
        if (storeProduct && storeProduct.quantity >= quantity) {
            storeProduct.quantity -= quantity
            if (storeProduct.save(flush: true)) {
                def storage = Storage.findByProducts(product)
                if (storage) {
                    new StorageService().addProductToStorage(storage, product, quantity)
                }
                return storeProduct
            } else {
                throw new RuntimeException("Failed to return product to storage")
            }
        } else {
            throw new RuntimeException("Insufficient stock or product not found")
        }
    }

}
