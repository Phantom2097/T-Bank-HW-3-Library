package presentation.show_actions

import data.ItemsInLibrary.setPosition
import data.Position
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

        val exit = selectAction(currentItem, num) ?: continue
        return exit
    }
}

private fun <T> selectAction(currentItem: T, num: Int): Boolean? where T : Showable, T : Readable {
    currentItem.apply {
        when (readlnOrNull()?.toIntOrNull() ?: -1) {
            1 -> {
                println(takeToHome())
                setPosition(num - 1, Position.HOME, currentItem)
                return false
            }
            2 -> {
                println(readInTheReadingRoom())
                setPosition(num - 1, Position.IN_READING_ROOM, currentItem)
                return false
            }
            3 -> println(fullInformation())
            4 -> {
                println(returnInLibrary())
                setPosition(num - 1, Position.LIBRARY, currentItem)
                return false
            }
            5 -> println(briefInformation() + "\n")
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

