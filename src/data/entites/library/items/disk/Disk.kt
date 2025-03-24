package data.entites.library.items.disk

interface Disk {
    var type: Type
}

enum class Type(private val type: String) {
    CD("CD"),
    DVD("DVD"),
    UNKNOWN("*Тип диска неизвестен*");

    fun getDiskType() = type
}