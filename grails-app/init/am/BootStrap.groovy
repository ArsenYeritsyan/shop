package am

import am.dto.ProductDTO
import am.dto.StorageDTO
import am.dto.StoreDTO
import am.service.ProductService
import am.service.StorageService
import am.service.StoreService

import java.time.LocalDate
import java.time.ZoneId

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
                new StoreDTO(code: 'ST001', name: 'Tech Store 1', address: '123 Tech Street'),
                new StoreDTO(code: 'ST002', name: 'Tech Store 2', address: '456 Tech Avenue')
        ]

        stores.each {
            storeService.save(it)
        }

        // Fetch stores for product association
        def store1 = storeService.findByCode('ST001')
        def store2 = storeService.findByCode('ST002')

        // Add products
        def products = [
                new ProductDTO(code: 'P001', name: 'Laptop', price: 1000.0, dateOfManufacture: toDate(LocalDate.now()), deadline: toDate(LocalDate.now().plusDays(365)), storeId: store1.id),
                new ProductDTO(code: 'P002', name: 'Smartphone', price: 700.0, dateOfManufacture: toDate(LocalDate.now()), deadline: toDate(LocalDate.now().plusDays(365)), storeId: store1.id),
                new ProductDTO(code: 'P003', name: 'Tablet', price: 500.0, dateOfManufacture: toDate(LocalDate.now()), deadline: toDate(LocalDate.now().plusDays(365)), storeId: store1.id),
                new ProductDTO(code: 'P004', name: 'Smartwatch', price: 200.0, dateOfManufacture: toDate(LocalDate.now()), deadline: toDate(LocalDate.now().plusDays(365)), storeId: store1.id),
                new ProductDTO(code: 'P005', name: 'Desktop PC', price: 1200.0, dateOfManufacture: toDate(LocalDate.now()), deadline: toDate(LocalDate.now().plusDays(365)), storeId: store2.id),
                new ProductDTO(code: 'P006', name: 'Monitor', price: 300.0, dateOfManufacture: toDate(LocalDate.now()), deadline: toDate(LocalDate.now().plusDays(365)), storeId: store2.id),
                new ProductDTO(code: 'P007', name: 'Keyboard', price: 50.0, dateOfManufacture: toDate(LocalDate.now()), deadline: toDate(LocalDate.now().plusDays(365)), storeId: store2.id),
                new ProductDTO(code: 'P008', name: 'Mouse', price: 30.0, dateOfManufacture: toDate(LocalDate.now()), deadline: toDate(LocalDate.now().plusDays(365)), storeId: store2.id),
                new ProductDTO(code: 'P009', name: 'Printer', price: 150.0, dateOfManufacture: toDate(LocalDate.now()), deadline: toDate(LocalDate.now().plusDays(365)), storeId: store1.id),
                new ProductDTO(code: 'P010', name: 'Router', price: 100.0, dateOfManufacture: toDate(LocalDate.now()), deadline: toDate(LocalDate.now().plusDays(365)), storeId: store2.id)
        ]

        products.each {
            productService.save(it)
        }

        // Add storages
        def storages = [
                new StorageDTO(code: 'S001', name: 'Warehouse A'),
                new StorageDTO(code: 'S002', name: 'Warehouse B')
        ]

        storages.each {
            storageService.save(it)
        }
    }

    private Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant())
    }
}
