package data.entites.items.disk

import data.LibraryService
import data.Position
import data.entites.Showable
import data.entites.Readable
import data.entites.items.LibraryItem
import presentation.colors.Colors.ANSI_GREEN
import presentation.colors.Colors.ANSI_RESET

class DiskImpl(
    private val item: LibraryItem,
    private val libraryService: LibraryService
) :
    Disk,
    Readable,
    Showable {

    override var type: String? = null

    private val name = item.name

    // Вывод информации
    override fun briefInformation(): String {
        val tempAvailability = if (item.availability) "Да" else "Нет"
        return "Диск \"$name\" доступен: $tempAvailability"
    }

    override fun fullInformation(): String = this.toString()

    // Возврат в библиотеку
    override fun returnInLibrary(): String =
        if (libraryService.setAvailability(true, item)) {

            libraryService.setPosition(Position.LIBRARY, item)

            "$ANSI_GREEN*Диск $name id: ${item.id} вернули в библиотеку*$ANSI_RESET\n" +
                    "Диск \"$name\" возвращен, спасибо\n"
        } else {
            "Диск \"$name\" не нужно возвращать, он всё ещё в библиотеке\n"
        }

    // Взять домой
    override fun takeToHome(): String =
        if (libraryService.setAvailability(false, item)) {

            libraryService.setPosition(Position.HOME, item)

            "$ANSI_GREEN*Диск $name} id: ${item.id} взяли домой*$ANSI_RESET\n" +
                    "Диск \"$name\" ваш, не забудьте вернуть в течение 30 дней\n"
        } else {
            "Извините диск \"$name\" нельзя получить, можете посмотреть другие\n" +
                    when (item.position) {
                        Position.HOME -> "$ANSI_GREEN*Диск забрали домой*$ANSI_RESET\n"
                        else -> "$ANSI_GREEN*Кажется мы его потеряли...*$ANSI_RESET\n"
                    }
        }

    override fun toString(): String {
        val tempAvailability = if (item.availability) "Да" else "Нет"
        return "${type ?: "*Тип диска неизвестен*"} $name доступен: $tempAvailability\n"
    }
}