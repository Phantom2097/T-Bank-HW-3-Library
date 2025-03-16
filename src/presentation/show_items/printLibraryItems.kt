package presentation.show_items

import data.LibraryRepository.getBooksInLibrary
import data.LibraryRepository.getDisksInLibrary
import data.LibraryRepository.getNewspapersInLibrary
import presentation.colors.Colors.ANSI_RESET
import presentation.colors.Colors.ANSI_YELLOW


fun printLibraryItems(itemsType: Int) = when (itemsType) {
    1 -> showItemsInLibrary(getBooksInLibrary())
    2 -> showItemsInLibrary(getNewspapersInLibrary())
    3 -> showItemsInLibrary(getDisksInLibrary())
    else -> println(ANSI_YELLOW + "Такой команды нет, попробуйте ещё раз" + ANSI_RESET)
}
