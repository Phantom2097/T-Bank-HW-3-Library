package presentation.show_actions

import data.entites.Readable
import data.entites.Showable
import presentation.colors.Colors.ANSI_CYAN
import presentation.colors.Colors.ANSI_RESET
import presentation.colors.Colors.ANSI_YELLOW

internal fun <T> showActions(num: Int, items: List<T>): Boolean where T : Readable, T : Showable {
    if ((num <= 0 || num > items.size)) {
        println(ANSI_YELLOW + "Неверный порядковый номер\n" + ANSI_CYAN + "\tПопробуйте ещё раз\n" + ANSI_RESET)
        return false
    }
    val currentItem = items[num - 1]

    while (true) {
        showActionsList()

        val exit = selectAction(currentItem) ?: continue
        return exit
    }
}

private fun showActionsList() {
    println(
        """
            |    1 - Взять домой 
            |    2 - Читать в читальном зале 
            |    3 - Показать подробную информацию
            |    4 - Вернуть в библиотеку 
            |    5 - Показать краткую информацию
            |    6 - Вернуться к выбору 
            |    7 - Выйти в стартовое меню
    """.trimMargin()
    )
}

