package data.entites.items

import data.Position

class LibraryItem(
    val name: String,
    val id: Int,
    var availability: Boolean = true,
    var position: Position = if (availability) Position.LIBRARY else Position.UNKNOWN
)

