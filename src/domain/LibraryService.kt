package domain

import data.Position
import data.entites.items.LibraryItem

class LibraryService {

    // Изменение позиции
    fun setPosition(position: Position, item: LibraryItem) {
        item.position = position
    }
    // Изменение доступности
    fun setAvailability(newAvailability: Boolean, item: LibraryItem): Boolean {
        if (newAvailability != item.availability) {
            item.availability = newAvailability
            return true
        }
        return false
    }
}