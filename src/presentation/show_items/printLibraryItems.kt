package presentation.show_items

import data.LibraryRepository.getBooksInLibrary
import data.LibraryRepository.getDisksInLibrary
import data.LibraryRepository.getItem
import data.LibraryRepository.getNewspapersInLibrary
import presentation.colors.Colors.ANSI_RESET
import presentation.colors.Colors.ANSI_YELLOW
import presentation.show_actions.showActions


fun printLibraryItems(itemsType: Int) {
    when (itemsType) {
        1 -> {
            while (true) {
                val books = getBooksInLibrary()
                val num = showItemsInLibrary(books) ?: return
                val item = getItem(books, num) ?: continue

                val exit = showActions(item)
                if (exit) return
            }

        }

        2 -> showItemsInLibrary(getNewspapersInLibrary())
        3 -> showItemsInLibrary(getDisksInLibrary())
        else -> {
            println(ANSI_YELLOW + "Такой команды нет, попробуйте ещё раз" + ANSI_RESET)
        }
    }
}
