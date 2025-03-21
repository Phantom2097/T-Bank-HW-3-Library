package presentation.show_digitize

import data.entites.library.Showable
import data.repository.LibraryRepository.addItem
import data.repository.LibraryRepository.getBooksInLibrary
import data.repository.LibraryRepository.getDigitizeItems
import data.repository.LibraryRepository.getNewspapersInLibrary
import domain.item_mappers.digitize.DigitizationOffice
import domain.item_mappers.digitize.DigitizationOffice.DigitizeBook
import domain.item_mappers.digitize.DigitizationOffice.DigitizeNewspaper
import presentation.colors.Colors.ANSI_CYAN
import presentation.colors.Colors.ANSI_RESET
import presentation.colors.Colors.ANSI_YELLOW
import presentation.show_items.showItems

fun goToDigitize(itemType: Int): Boolean {
    return when (itemType) {
        1 -> {
            digitizer(
                "книгу",
                { getBooksInLibrary() },
                { book -> DigitizeBook(book) },
            )
            true
        }
        2 -> {
            digitizer (
                "газету",
                { getNewspapersInLibrary() },
                { newspaper -> DigitizeNewspaper(newspaper) },
            )
            true
        }
        3 -> {
            getDigitizeItems().showItems()
            false
        }

        4 -> true
        else -> {
            println(ANSI_YELLOW + "Неизвестная команда\n" + ANSI_CYAN + "\tПопробуйте ещё раз\n" + ANSI_RESET)
            false
        }
    }
}

inline fun <reified T : Showable> digitizer(
    itemName: String,
    getItems : () -> List<T>,
    digitizeItem: (T) -> DigitizationOffice,
) {
    while (true) {
        println("Выберите $itemName для оцифровки")

        val newspaper = selectItemForDigitize { getItems() } ?: return

        val dNewspaper = digitizeItem(newspaper).toDigitize()

        addItem(dNewspaper)

        println(dNewspaper)
    }
}