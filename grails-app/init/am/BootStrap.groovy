package am

import am.domain.Store
import am.service.ProductService
import am.service.ProductServiceI
import am.service.StorageService
import am.service.StoreService
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date

class BootStrap {

    ProductService productService
    StorageService storageService
    StoreService storeService

    def init = { servletContext ->
        addInitialData()
    }

    def destroy = {
    }

    private void addInitialData() {
        // Add stores
        def stores = [
                [code: 'ST001', name: 'Tech Store 1', address: '123 Tech Street'],
                [code: 'ST002', name: 'Tech Store 2', address: '456 Tech Avenue']
        ]

        stores.each {
            storeService.save(it.code, it.name, it.address)
        }

        // Fetch stores for product association
        def store1 = storeService.findByCode('ST001')
        def store2 = storeService.findByCode('ST002')

        // Add products
        def products = [
                [code: 'P001', name: 'Laptop', price: 1000.0, dateOfManufacture: toDate(LocalDate.now()), deadline: toDate(LocalDate.now().plusDays(365)), store: store1],
                [code: 'P002', name: 'Smartphone', price: 700.0, dateOfManufacture: toDate(LocalDate.now()), deadline: toDate(LocalDate.now().plusDays(365)), store: store1],
                [code: 'P003', name: 'Tablet', price: 500.0, dateOfManufacture: toDate(LocalDate.now()), deadline: toDate(LocalDate.now().plusDays(365)), store: store1],
                [code: 'P004', name: 'Smartwatch', price: 200.0, dateOfManufacture: toDate(LocalDate.now()), deadline: toDate(LocalDate.now().plusDays(365)), store: store1],
                [code: 'P005', name: 'Desktop PC', price: 1200.0, dateOfManufacture: toDate(LocalDate.now()), deadline: toDate(LocalDate.now().plusDays(365)), store: store2],
                [code: 'P006', name: 'Monitor', price: 300.0, dateOfManufacture: toDate(LocalDate.now()), deadline: toDate(LocalDate.now().plusDays(365)), store: store2],
                [code: 'P007', name: 'Keyboard', price: 50.0, dateOfManufacture: toDate(LocalDate.now()), deadline: toDate(LocalDate.now().plusDays(365)), store: store2],
                [code: 'P008', name: 'Mouse', price: 30.0, dateOfManufacture: toDate(LocalDate.now()), deadline: toDate(LocalDate.now().plusDays(365)), store: store2],
                [code: 'P009', name: 'Printer', price: 150.0, dateOfManufacture: toDate(LocalDate.now()), deadline: toDate(LocalDate.now().plusDays(365)), store: store1],
                [code: 'P010', name: 'Router', price: 100.0, dateOfManufacture: toDate(LocalDate.now()), deadline: toDate(LocalDate.now().plusDays(365)), store: store2]
        ]

        products.each {
            productService.save(it.code as String, it.name as String, it.price as BigDecimal, it.dateOfManufacture as Date, it.deadline as Date, (Store)it.store)
        }

        // Add storages
        def storages = [
                [code: 'S001', name: 'Warehouse A'],
                [code: 'S002', name: 'Warehouse B']
        ]

        storages.each {
            storageService.save(it.code, it.name)
        }
    }

    private Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant())
    }
}
