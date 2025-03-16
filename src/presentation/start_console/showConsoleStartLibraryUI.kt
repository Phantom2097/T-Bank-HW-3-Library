package presentation.start_console

import presentation.colors.Colors.ANSI_RESET
import presentation.colors.Colors.ANSI_YELLOW
import presentation.main.printLibraryItems

internal fun showConsoleStartLibraryUI() {
    while (true) {
        textForShowLibraryItems()

        val exit = actionSelection(::printLibraryItems)
        if (exit) return
    }
}

private fun textForShowLibraryItems() {
    println(
        """
            Введите число, чтобы посмотреть соответствующую подборку в библиотеке
                1 - Посмотреть книги
                2 - Посмотреть газеты
                3 - Посмотреть диски
                4 - Выход из меню библиотеки
            """.trimIndent()
    )
}

private fun actionSelection(method: (Int) -> Unit): Boolean {
    return when (val elementType = readlnOrNull()?.toIntOrNull()) {
        null -> {
            println(ANSI_YELLOW + "Попробуйте ещё раз\n" + ANSI_RESET)
            false
        }

        4 -> true
        else -> {
            method(elementType)
            false
        }
    }
}