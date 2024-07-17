package shop

class Storage {
    String code
    String name
    static hasMany = [products: StorageProduct]

    static constraints = {
        code blank: false, unique: true
        name blank: false
    }
}

class StorageProduct {
    Product product
    int quantity

    static belongsTo = [storage: Storage]

    static constraints = {
        quantity min: 0
    }
}
