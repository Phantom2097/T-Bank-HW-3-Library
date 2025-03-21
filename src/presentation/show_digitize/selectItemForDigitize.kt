package presentation.show_digitize

import data.entites.library.Showable
import data.repository.LibraryRepository.getItem
import presentation.show_items.getItemNumber
import presentation.show_items.showItems

inline fun <reified LibraryType: Showable>selectItemForDigitize(getItems: () -> List<LibraryType>): LibraryType? {
    val items = getItems()
    while (true) {
        items.apply {
            showItems()

            val num = getItemNumber() ?: return null

            val item = getItem(items, num) ?: return@apply

            return item
        }
    }

}