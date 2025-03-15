package data.entites.items

import data.Position
import data.entites.Readable
import data.entites.Takeable

abstract class LibraryItem(
    val name: String,
    val id: Int,
    var availability: Boolean = true,
    var position: Position = if (availability) Position.LIBRARY else Position.UNKNOWN
) : Readable,
    Takeable {

    open fun briefInformation(): String {
        val tempAvailability = if (availability) "Да" else "Нет"
        return "$name доступно: $tempAvailability"
    }

    open fun returnInLibrary(): String = if (!availability) {
        availability = true
        "Предмет $name $id возвращён в библиотеку"
    } else {
        "Предмет не нужно возвращать, он всё ещё в библиотеке"
    }


    abstract fun fullInformation(): String
}

