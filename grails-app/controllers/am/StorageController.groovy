package am

import am.dto.StorageDTO
import am.service.StorageService

class StorageController {

    StorageService storageService

    static allowedMethods = [save: 'POST', update: 'POST', delete: 'POST']

    def index() {
        respond([storageList: storageService.findAll()])
    }

    def save(StorageDTO storageDTO) {
        try {
            storageService.save(storageDTO)
            flash.message = "Storage saved successfully"
        } catch (Exception e) {
            flash.message = "Failed to save storage: ${e.message}"
        }
        redirect(controller: 'application', action: 'index')
    }

    def delete(Long id) {
        storageService.deleteById(id)
        flash.message = "Storage deleted successfully"
        redirect(controller: 'application', action: 'index')
    }

    def edit(Long id) {
        def storage = storageService.findById(id)
        if (!storage) {
            flash.message = "Storage not found"
            redirect(controller: 'application', action: 'index')
            return
        }
        render(view: 'edit', model: [storage: storage])
    }

    def update(StorageDTO storageDTO) {
        try {
            storageService.update(params.id.toLong(), storageDTO)
            flash.message = "Storage updated successfully"
        } catch (Exception e) {
            flash.message = "Failed to update storage: ${e.message}"
            render(view: 'edit', model: [storage: storageService.findById(params.id.toLong())])
            return
        }
        redirect(controller: 'application', action: 'index')
    }
}
