package data.entites.items.book

import data.Position
import data.entites.Readable
import data.entites.Takeable
import data.entites.items.LibraryItem
import presentation.colors.Colors.ANSI_GREEN
import presentation.colors.Colors.ANSI_RESET

class BookImpl(
    name: String,
    id: Int,
    availability: Boolean,
) : LibraryItem(name, id, availability),
    Book,
    Readable,
    Takeable {

    override lateinit var author: String
    override var numberOfPages: Int? = null

    // Вывод информации
    override fun briefInformation(): String {
        val tempAvailability = if (availability) "Да" else "Нет"
        return "Книга \"$name\" доступна: $tempAvailability"
    }

    override fun fullInformation(): String = this.toString()

    override fun returnInLibrary(): String =
        if (!availability) {
            availability = true
            "$ANSI_GREEN*Книга $name $id возвращена в библиотеку*$ANSI_RESET\n" +
                    "Книга \"$name\" возвращена, спасибо\n"
        } else {
            "Книгу \"$name\" не нужно возвращать, она всё ещё в библиотеке\n"
        }

    override fun readInTheReadingRoom(): String =
        if (availability) {
            availability = false
            "$ANSI_GREEN*Книга $name $id взяли в читальный зал*$ANSI_RESET\n" +
                    "Книга \"$name\" ваша, не забудьте вернуть до закрытия\n"
        } else {
            "Извините книгу \"$name\" нельзя получить, можете посмотреть другие\n" +
                    when (position) {
                        Position.IN_READING_ROOM -> "$ANSI_GREEN*Книгу забрали в читальный зал*$ANSI_RESET\n"
                        Position.HOME -> "$ANSI_GREEN*Книгу забрали домой*$ANSI_RESET\n"
                        else -> "$ANSI_GREEN*Кажется мы его потеряли...*$ANSI_RESET\n"
                    }
        }

    override fun takeToHome(): String =
        if (availability) {
            availability = false
            "$ANSI_GREEN*Книга $name $id взяли домой*$ANSI_RESET\n" +
                    "Книга \"$name\" ваша, не забудьте вернуть в течение 30 дней\n"
        } else {
            "Извините книгу \"$name\" нельзя получить, можете посмотреть другие\n" +
                    when (position) {
                        Position.IN_READING_ROOM -> "$ANSI_GREEN*Книгу забрали в читальный зал*$ANSI_RESET\n"
                        Position.HOME -> "$ANSI_GREEN*Книгу забрали домой*$ANSI_RESET\n"
                        else -> "$ANSI_GREEN*Кажется мы его потеряли...*$ANSI_RESET\n"
                    }
        }


    override fun toString(): String {
        val tempAvailability = if (availability) "Да" else "Нет"
        val tempNumberOfPages = if (numberOfPages != -1) numberOfPages.toString() else "*неизвестно*"
        val tempAuthor = author.ifBlank { "*неизвестно*" }
        return "Книга: $name ($tempNumberOfPages стр.) автора: $tempAuthor с id: $id доступна: $tempAvailability\n"
    }
}