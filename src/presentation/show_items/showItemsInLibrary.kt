package presentation.show_items

import data.entites.items.LibraryItem
import presentation.colors.Colors.ANSI_BLUE
import presentation.colors.Colors.ANSI_RESET
import presentation.show_actions.showActions

fun <T : LibraryItem>showItemsInLibrary(items: List<T>) {
    if (items.isEmpty()) return

    items.apply {
        while (true) {
            forEachIndexed { i, item ->
                println(ANSI_BLUE + "\t${i + 1} - " + ANSI_RESET + item.briefInformation())
            }

            println("\nВведите номер для дальнейших действий\nНажмите Enter для выхода")

            val num = readlnOrNull()?.run {
                if (isBlank()) return
                else toIntOrNull()
            } ?: -1

            val exit = showActions(num, this)
            if (exit) return
            else continue
        }
    }
}