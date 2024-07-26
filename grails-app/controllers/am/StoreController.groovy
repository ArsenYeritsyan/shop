package am

import am.dto.StoreDTO
import am.service.StoreService
import am.service.StoreServiceI

class StoreController {

    StoreService storeService

    static allowedMethods = [save: 'POST', update: 'POST', delete: 'POST']

    def index() {
        respond([storeList: storeService.findAll()])
    }

    def save(StoreDTO storeDTO) {
        try {
            storeService.save(storeDTO)
            flash.message = "Store saved successfully"
        } catch (Exception e) {
            flash.message = "Failed to save store: ${e.message}"
        }
        redirect(controller: 'application', action: 'index')
    }

    def delete(Long id) {
        storeService.deleteById(id)
        flash.message = "Store deleted successfully"
        redirect(controller: 'application', action: 'index')
    }

    def edit(Long id) {
        def store = storeService.findById(id)
        if (!store) {
            flash.message = "Store not found"
            redirect(controller: 'application', action: 'index')
            return
        }
        render(view: 'edit', model: [store: store])
    }

    def update(StoreDTO storeDTO) {
        try {
            storeService.update(params.id.toLong(), storeDTO)
            flash.message = "Store updated successfully"
        } catch (Exception e) {
            flash.message = "Failed to update store: ${e.message}"
            render(view: 'edit', model: [store: storeService.findById(params.id.toLong())])
            return
        }
        redirect(controller: 'application', action: 'index')
    }
}
