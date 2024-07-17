package shop

class Product {
    String code
    String name
    BigDecimal price
    Date dateOfManufacture
    Date deadline

    static constraints = {
        code blank: false, unique: true
        name blank: false
        price min: 0.0
        dateOfManufacture nullable: false
        deadline nullable: true
    }
}
