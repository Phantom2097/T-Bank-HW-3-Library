package data.entites.items.disk

import data.Position
import data.entites.Takeable
import data.entites.items.LibraryItem
import presentation.colors.Colors.ANSI_GREEN
import presentation.colors.Colors.ANSI_RESET

class DiskImpl(
    name: String,
    id: Int,
    availability: Boolean,
    position: Position = if (availability) Position.LIBRARY else Position.UNKNOWN
) : LibraryItem(name, id, availability),
    Disk,
    Takeable {
    override var type: String? = null

    // Вывод информации
    override fun briefInformation(): String {
        val tempAvailability = if (availability) "Да" else "Нет"
        return "Диск $name доступен: $tempAvailability"
    }

    override fun fullInformation(): String = this.toString()

    override fun returnInLibrary(): String =
        if (!availability) {
            availability = true
            "$ANSI_GREEN*Диск $name $id вернули в библиотеку*$ANSI_RESET\n" +
                    "Диск \"$name\" возвращен, спасибо\n"
        } else {
            "Диск \"$name\" не нужно возвращать, он всё ещё в библиотеке\n"
        }


    override fun takeToHome(): String =
        if (availability) {
            availability = false
            "$ANSI_GREEN*Диск $name $id взяли домой*$ANSI_RESET\n" +
                    "Диск \"$name\" ваш, не забудьте вернуть в течение 30 дней\n"
        } else {
            "Извините диск \"$name\" уже взяли, можете посмотреть другие\n"
        }

    override fun toString(): String {
        val tempAvailability = if (availability) "Да" else "Нет"
        return "$type $name $tempAvailability\n"
    }
}