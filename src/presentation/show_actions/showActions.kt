package presentation.show_actions

import data.ItemsInLibrary.setPosition
import data.Position
import data.entites.items.LibraryItem
import presentation.colors.Colors.ANSI_CYAN
import presentation.colors.Colors.ANSI_RESET
import presentation.colors.Colors.ANSI_YELLOW

fun <T : LibraryItem> showActions(num: Int, items: List<T>): Boolean {
    if ((num <= 0 || num > items.size)) {
        println(ANSI_YELLOW + "Неверный порядковый номер\n" + ANSI_CYAN + "\tПопробуйте ещё раз\n" + ANSI_RESET)
        return false
    }
    val currentItem = items[num - 1]

    while (true) {
        showActionsList()

        val exit = selectAction(currentItem, num) ?: continue
        return exit
    }
}

private fun <T : LibraryItem> selectAction(currentItem: T, num: Int): Boolean? {
    currentItem.apply {
        when (readlnOrNull()?.toIntOrNull() ?: -1) {
            1 -> println(briefInformation())
            2 -> println(fullInformation())
            3 -> {
                println(readInTheReadingRoom())
                setPosition(num - 1, Position.IN_READING_ROOM, currentItem)
                return false
            }
            4 -> {
                println(takeToHome())
                setPosition(num - 1, Position.HOME, currentItem)
                return false
            }
            5 -> {
                println(returnInLibrary())
                setPosition(num - 1, Position.LIBRARY, currentItem)
                return false
            }
            6 -> return false
            7 -> return true
            else -> {
                println(ANSI_YELLOW + "Неизвестная команда\n" + ANSI_CYAN + "\tПопробуйте ещё раз\n" + ANSI_RESET)
                return@apply
            }
        }
    }
    return null
}

private fun showActionsList() {
    println(
        """
            |    1 - Вывести краткую информацию
            |    2 - Вывести подробную информацию
            |    3 - Читать в зале
            |    4 - Взять домой
            |    5 - Вернуть в библиотеку 
            |    6 - Вернуться к выбору 
            |    7 - Выйти в стартовое 
    """.trimMargin()
    )
}

