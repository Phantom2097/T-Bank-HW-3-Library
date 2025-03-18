package presentation.start_console

import presentation.show_items.printLibraryItems


internal fun showConsoleStartLibraryUI() {
    while (true) {
        textForShowLibraryItems()

        val exit = selectLibrarySelection(::printLibraryItems)
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
                4 - Управление менеджером
                5 - Выход из меню библиотеки
            """.trimIndent()
    )
}

