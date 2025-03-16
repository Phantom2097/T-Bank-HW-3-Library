package data.entites.items.disk

import data.Position
import data.entites.Showable
import data.entites.Readable
import data.entites.items.LibraryItem
import presentation.colors.Colors.ANSI_GREEN
import presentation.colors.Colors.ANSI_RESET

class DiskImpl(val item: LibraryItem) :
    Disk,
    Readable,
    Showable {

    override var type: String? = null

    // Вывод информации
    override fun briefInformation(): String {
        val tempAvailability = if (item.availability) "Да" else "Нет"
        return "Диск ${item.name} доступен: $tempAvailability"
    }

    override fun fullInformation(): String = this.toString()

    // Возврат в библиотеку
    override fun returnInLibrary(): String =
        if (!item.availability) {
            item.availability = true
            "$ANSI_GREEN*Диск ${item.name} id: ${item.id} вернули в библиотеку*$ANSI_RESET\n" +
                    "Диск \"${item.name}\" возвращен, спасибо\n"
        } else {
            "Диск \"${item.name}\" не нужно возвращать, он всё ещё в библиотеке\n"
        }

    // Взять домой
    override fun takeToHome(): String =
        if (item.availability) {
            item.availability = false
            "$ANSI_GREEN*Диск ${item.name} id: ${item.id} взяли домой*$ANSI_RESET\n" +
                    "Диск \"${item.name}\" ваш, не забудьте вернуть в течение 30 дней\n"
        } else {
            "Извините диск \"${item.name}\" нельзя получить, можете посмотреть другие\n" +
                    when (item.position) {
                        Position.HOME -> "$ANSI_GREEN*Диск забрали домой*$ANSI_RESET\n"
                        else -> "$ANSI_GREEN*Кажется мы его потеряли...*$ANSI_RESET\n"
                    }
        }

    override fun toString(): String {
        val tempAvailability = if (item.availability) "Да" else "Нет"
        return "${type ?: "*Тип диска неизвестен*"} ${item.name} доступен: $tempAvailability\n"
    }
}