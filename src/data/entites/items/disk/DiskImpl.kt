package data.entites.items.disk

import data.Position
import data.entites.Takeable
import data.entites.items.LibraryItem
import presentation.colors.Colors.ANSI_GREEN
import presentation.colors.Colors.ANSI_RESET

class DiskImpl(
    name: Any,
    id: Int,
    availability: Boolean = true,
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
            "$ANSI_GREEN*Диск $name id: $id вернули в библиотеку*$ANSI_RESET\n" +
                    "Диск \"$name\" возвращен, спасибо\n"
        } else {
            "Диск \"$name\" не нужно возвращать, он всё ещё в библиотеке\n"
        }


    override fun takeToHome(): String =
        if (availability) {
            availability = false
            "$ANSI_GREEN*Диск $name id: $id взяли домой*$ANSI_RESET\n" +
                    "Диск \"$name\" ваш, не забудьте вернуть в течение 30 дней\n"
        } else {
            "Извините диск \"$name\" нельзя получить, можете посмотреть другие\n" +
                    when (position) {
                        Position.HOME -> "$ANSI_GREEN*Диск забрали домой*$ANSI_RESET\n"
                        else -> "$ANSI_GREEN*Кажется мы его потеряли...*$ANSI_RESET\n"
                    }
        }

    override fun toString(): String {
        val tempAvailability = if (availability) "Да" else "Нет"
        return "${type ?: "*Тип диска неизвестен*"} $name доступен: $tempAvailability\n"
    }
}