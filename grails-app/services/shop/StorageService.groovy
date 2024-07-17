package shop

class StorageService {
    def addProductToStorage(Storage storage, Product product, int quantity) {
        def storageProduct = new StorageProduct(product: product, quantity: quantity)
        storage.addToProducts(storageProduct)
        if (storage.save(flush: true)) {
            return storage
        } else {
            throw new RuntimeException("Failed to add product to storage")
        }
    }

    def removeProductFromStorage(Storage storage, Product product) {
        def storageProduct = StorageProduct.findByStorageAndProduct(storage, product)
        if (storageProduct) {
            storage.removeFromProducts(storageProduct)
            storageProduct.delete(flush: true)
            if (storage.save(flush: true)) {
                return storage
            } else {
                throw new RuntimeException("Failed to remove product from storage")
            }
        } else {
            throw new RuntimeException("Product not found in storage")
        }
    }
}
