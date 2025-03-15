package data.entites.items.newspaper

import data.Position
import data.entites.Readable
import data.entites.items.LibraryItem
import presentation.colors.Colors.ANSI_GREEN
import presentation.colors.Colors.ANSI_RESET

class NewspaperImpl(
    name: String,
    id: Int,
    availability: Boolean = true,
    position: Position = if (availability) Position.LIBRARY else Position.UNKNOWN
) : LibraryItem(name, id, availability),
    Newspaper,
    Readable {

    override var issueNumber: Int? = null

    // Вывод информации
    override fun briefInformation(): String {
        val tempAvailability = if (availability) "Да" else "Нет"
        return "Газета $name выпуск ${issueNumber ?: "*неизвестно*"} доступна: $tempAvailability"
    }

    override fun fullInformation(): String = this.toString()

    override fun readInTheReadingRoom(): String =
        if (availability) {
            availability = false
            "$ANSI_GREEN*Газета $name выпуск ${issueNumber ?: "*неизвестно*"} id: $id взяли в читальный зал*$ANSI_RESET\n" +
                    "Газета \"$name\" ваша, не забудьте вернуть до закрытия\n"
        } else {
            "Извините газету \"$name\" нельзя получить, можете посмотреть другие\n" +
                    when (position) {
                        Position.IN_READING_ROOM -> "$ANSI_GREEN*Газету взяли в читальный зал*$ANSI_RESET\n"
                        else -> "$ANSI_GREEN*Кажется мы её потеряли...*$ANSI_RESET\n"
                    }
        }


    override fun returnInLibrary(): String =
        if (!availability) {
            availability = true
            "$ANSI_GREEN*Газета $name выпуск ${issueNumber ?: "*неизвестно*"} id: $id вернули в библиотеку*$ANSI_RESET\n" +
                    "Газета \"$name\" возвращена\n"
        } else {
            "Газету \"$name\" не нужно возвращать, она всё ещё в библиотеке\n"
        }


    override fun toString(): String {
        val tempAvailability = if (availability) "Да" else "Нет"
        return "Выпуск: ${issueNumber ?: "*неизвестно*"} газеты $name с id: $id доступен: $tempAvailability\n"
    }
}

