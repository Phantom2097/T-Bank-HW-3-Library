package presentation.main

import data.ItemsInLibrary.getBooksInLibrary
import data.ItemsInLibrary.getDisksInLibrary
import data.ItemsInLibrary.getNewspapersInLibrary
import presentation.colors.Colors.ANSI_RESET
import presentation.colors.Colors.ANSI_YELLOW
import presentation.show_items.showItemsInLibrary


internal fun printLibraryItems(itemsType: Int) = when (itemsType) {
    1 -> showItemsInLibrary(getBooksInLibrary())
    2 -> showItemsInLibrary(getNewspapersInLibrary())
    3 -> showItemsInLibrary(getDisksInLibrary())
    else -> println(ANSI_YELLOW + "Такой команды нет, попробуйте ещё раз" + ANSI_RESET)
}
