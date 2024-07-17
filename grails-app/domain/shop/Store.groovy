package shop

class Store {
    String code
    String name
    String address
    static hasMany = [products: StoreProduct]

    static constraints = {
        code blank: false, unique: true
        name blank: false
        address blank: false
    }
}

class StoreProduct {
    Product product
    int quantity

    static belongsTo = [store: Store]

    static constraints = {
        quantity min: 0
    }
}
