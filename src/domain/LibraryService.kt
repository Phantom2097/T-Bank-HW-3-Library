package domain

import data.Position
import data.entites.library.items.LibraryItem

class LibraryService {

    // Изменение позиции
    fun setPosition(position: Position, item: LibraryItem) {
        item.position = position
    }
    // Изменение доступности
    fun setAvailability(newAvailability: Boolean, item: LibraryItem): Boolean {
        return newAvailability != item.availability.also {
            item.availability = newAvailability
        }
    }


}