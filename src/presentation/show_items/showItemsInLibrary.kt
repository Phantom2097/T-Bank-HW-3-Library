package presentation.show_items

import data.entites.Readable
import data.entites.Showable
import presentation.colors.Colors.ANSI_BLUE
import presentation.colors.Colors.ANSI_RESET

// Сделать в этой функции возврат номера элемента и обработать его там, где ещё имеем тип
fun <T> showItemsInLibrary(items: List<T>): Int? where T : Showable, T : Readable {
//    if (items.isEmpty()) return -1

    items.apply {
//        while (true) {
        forEachIndexed { i, item ->
            println(ANSI_BLUE + "\t${i + 1} - " + ANSI_RESET + item.briefInformation())
        }

        println("\nВведите номер для дальнейших действий\nНажмите Enter для выхода")

        return (readlnOrNull()?.run {
            if (isBlank()) return null
            else toIntOrNull()
        } ?: 0) - 1
//        return (readlnOrNull()?.toIntOrNull() ?: 0) - 1

//            val exit = showActions(num, this)
//            if (exit) return -1
//        }
    }
}